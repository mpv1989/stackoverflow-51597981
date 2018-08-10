package com.mpv.stackoverflow;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.arangodb.springframework.core.ArangoOperations;
import com.mpv.stackoverflow.entity.Departure;
import com.mpv.stackoverflow.entity.DepartureToTrip;
import com.mpv.stackoverflow.entity.Driver;
import com.mpv.stackoverflow.entity.Trip;
import com.mpv.stackoverflow.entity.TripToDriver;
import com.mpv.stackoverflow.repository.TripRepository;

/**
 * @author Mark Vollmary
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyConfiguration.class })
public class MyTest {

	@Autowired
	ArangoOperations operations;
	@Autowired
	TripRepository tripRepository;

	@Before
	public void before() {
		final Departure departure = new Departure(LocalDate.of(2018, 07, 30));
		final Trip trip = new Trip();
		final Driver driver = new Driver("999999-9999");

		operations.insert(departure);
		operations.insert(trip);
		operations.insert(driver);

		operations.insert(new DepartureToTrip(departure, trip));
		operations.insert(new TripToDriver(trip, driver));
	}

	@After
	public void after() {
		operations.dropDatabase();
	}

	@Test
	public void findTripsByStringQuery() {
		final Iterable<Trip> trips = tripRepository.findTrips("999999-9999", LocalDate.of(2018, 07, 30));
		assertThat(trips.iterator().hasNext(), is(true));
	}

	@Test
	public void findTripsByDerivedQuery() {
		final Iterable<Trip> trips = tripRepository
				.findByDriversIdNumberAndDeparturesStartTimeGreaterThanEqual("999999-9999", LocalDate.of(2018, 07, 30));
		assertThat(trips.iterator().hasNext(), is(true));
	}

}
