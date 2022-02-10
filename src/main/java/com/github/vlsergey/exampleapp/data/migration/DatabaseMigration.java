package com.github.vlsergey.exampleapp.data.migration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Profile;

@Profile("databaseMigration")
@SpringBootConfiguration
@EnableAutoConfiguration
public class DatabaseMigration {

}
