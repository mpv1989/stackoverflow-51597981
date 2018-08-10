package com.mpv.stackoverflow;

import org.springframework.context.annotation.Configuration;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDB.Builder;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.AbstractArangoConfiguration;

/**
 * @author Mark Vollmary
 *
 */
@Configuration
@EnableArangoRepositories(basePackages = "com.mpv.stackoverflow.repository")
public class MyConfiguration extends AbstractArangoConfiguration {

	@Override
	protected Builder arango() {
		return new ArangoDB.Builder().host("192.168.10.9", 9000);
	}

	@Override
	protected String database() {
		return "so-51597981";
	}

}
