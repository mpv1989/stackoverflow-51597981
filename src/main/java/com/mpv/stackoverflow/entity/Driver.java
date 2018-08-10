package com.mpv.stackoverflow.entity;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;

/**
 * @author Mark Vollmary
 *
 */
@Document
@Data
public class Driver {

	@Id
	private String id;

	private final String idNumber;

}
