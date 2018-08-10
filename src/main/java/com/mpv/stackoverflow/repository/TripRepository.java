package com.mpv.stackoverflow.repository;

import java.time.LocalDate;

import org.springframework.data.repository.query.Param;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import com.mpv.stackoverflow.entity.Trip;

/**
 * @author Mark Vollmary
 *
 */
public interface TripRepository extends ArangoRepository<Trip> {

	@Query("FOR doc IN trip "//
			+ "FILTER (FOR v IN 1..1 OUTBOUND doc tripToDriver FILTER v.idNumber == @idNumber LIMIT 1 RETURN true)[0] "//
			+ "FILTER (FOR v IN 1..1 INBOUND doc departureToTrip FILTER v.startTime >= @startTime LIMIT 1 RETURN true)[0] "//
			+ "RETURN doc")
	Iterable<Trip> findTrips(@Param("idNumber") String idNumber, @Param("startTime") LocalDate startTime);

	Iterable<Trip> findByDriversIdNumberAndDeparturesStartTimeGreaterThanEqual(String idNumber, LocalDate startTime);

}
