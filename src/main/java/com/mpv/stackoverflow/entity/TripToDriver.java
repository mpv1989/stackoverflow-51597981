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
public class TripToDriver {

	@Id
	private String id;

	@From
	private final Trip trip;

	@To
	private final Driver driver;

}
