package com.github.vlsergey.exampleapp.utils;

import lombok.SneakyThrows;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T, E extends Throwable> extends Consumer<T> {

	@Override
	@SneakyThrows
	default void accept(T t) {
		acceptWithThrows(t);
	}

	void acceptWithThrows(T t) throws E;

}
