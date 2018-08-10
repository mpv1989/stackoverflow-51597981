package com.mpv.stackoverflow.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;

/**
 * @author Mark Vollmary
 *
 */
@Document
@Data
public class Departure {

	@Id
	private String id;

	private final LocalDate startTime;

}
