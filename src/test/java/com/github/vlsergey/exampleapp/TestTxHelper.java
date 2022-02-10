package com.github.vlsergey.exampleapp;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.vlsergey.exampleapp.utils.ThrowingCallable;
import com.github.vlsergey.exampleapp.utils.ThrowingRunnable;

public class TestTxHelper {

	@Transactional(propagation = Propagation.REQUIRED)
	public <R, E extends Throwable> R txRequired(ThrowingCallable<R, E> runnable) throws E {
		return runnable.call();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public <E extends Throwable> void txRequired(ThrowingRunnable<E> runnable) throws E {
		runnable.run();
	}

}
