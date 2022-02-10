package com.github.vlsergey.exampleapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.StandardEnvironment;

import com.github.vlsergey.exampleapp.data.migration.DatabaseMigration;

public class Application {
	public static void main(String[] args) {
		if (Arrays.asList(new StandardEnvironment().getActiveProfiles()).contains("databaseMigration")) {
			SpringApplication.run(DatabaseMigration.class, args);
			return;
		}

		SpringApplication.run(new Class<?>[] { DefaultConfiguration.class, SchedulingConfiguration.class }, args);
	}
}
