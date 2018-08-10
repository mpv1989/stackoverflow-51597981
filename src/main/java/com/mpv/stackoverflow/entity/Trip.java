package com.mpv.stackoverflow.entity;

import java.util.Collection;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import com.arangodb.springframework.annotation.Relations.Direction;

import lombok.Data;

/**
 * @author Mark Vollmary
 *
 */
@Document
@Data
public class Trip {

	@Id
	private String id;

	@Relations(edges = TripToDriver.class, direction = Direction.OUTBOUND, maxDepth = 1)
	private Collection<Driver> drivers;

	@Relations(edges = DepartureToTrip.class, direction = Direction.INBOUND, maxDepth = 1)
	private Collection<Departure> departures;

}
