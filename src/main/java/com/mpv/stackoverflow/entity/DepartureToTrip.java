package com.mpv.stackoverflow.entity;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.Data;

/**
 * @author Mark Vollmary
 *
 */
@Edge
@Data
public class DepartureToTrip {

	@Id
	private String id;

	@From
	private final Departure departure;

	@To
	private final Trip trip;

}
