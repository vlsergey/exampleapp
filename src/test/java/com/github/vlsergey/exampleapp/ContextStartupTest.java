package com.github.vlsergey.exampleapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@TestWithSpringContext
class ContextStartupTest {

	@Autowired
	private ApplicationContext context;

	@Test
	void testThatContextIsUp() {
		assertNotNull(context);
	}

}
