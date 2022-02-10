package com.github.vlsergey.exampleapp.utils;

import lombok.SneakyThrows;

import java.util.function.Supplier;

@FunctionalInterface
public interface ThrowingCallable<T, E extends Throwable> extends Supplier<T> {

    T call() throws E;

    @Override
    @SneakyThrows
    default T get() {
        return call();
    }

}
