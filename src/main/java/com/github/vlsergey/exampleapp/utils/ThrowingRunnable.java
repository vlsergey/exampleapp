package com.github.vlsergey.exampleapp.utils;

@FunctionalInterface
public interface ThrowingRunnable<E extends Throwable> {

	void run() throws E;

}
