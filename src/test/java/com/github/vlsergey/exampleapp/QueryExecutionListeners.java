package com.github.vlsergey.exampleapp;

import static java.util.Collections.synchronizedSet;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.internal.util.collections.IdentitySet;

import com.github.vlsergey.exampleapp.utils.ThrowingRunnable;

import lombok.NonNull;
import lombok.SneakyThrows;
import net.ttddyy.dsproxy.ExecutionInfo;
import net.ttddyy.dsproxy.QueryInfo;
import net.ttddyy.dsproxy.listener.QueryExecutionListener;

public class QueryExecutionListeners implements QueryExecutionListener {

	@SuppressWarnings("unchecked")
	private final Set<QueryExecutionListener> listeners = synchronizedSet(new IdentitySet());

	@Override
	public void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
		listeners.forEach(l -> l.afterQuery(execInfo, queryInfoList));
	}

	@Override
	public void beforeQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
		listeners.forEach(l -> l.beforeQuery(execInfo, queryInfoList));
	}

	@SneakyThrows
	public <E extends Throwable> @NonNull String getFirstQuery(final @NonNull ThrowingRunnable<E> runnable) {
		return getQueries(runnable).get(0);
	}

	@SneakyThrows
	public <E extends Throwable> @NonNull List<String> getQueries(final @NonNull ThrowingRunnable<E> runnable) {
		final Thread ownerThread = Thread.currentThread();

		LinkedList<String> queries = new LinkedList<>();
		withListener(new QueryExecutionListener() {

			@Override
			public void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {

			}

			@Override
			public void beforeQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
				if (ownerThread != Thread.currentThread()) {
					return;
				}

				queryInfoList.stream().map(QueryInfo::getQuery).forEach(queries::add);
			}
		}, runnable);

		assertTrue(!queries.isEmpty(), "Expected at least single query to be registered by QueryExecutionListener");
		return queries;
	}

	@SneakyThrows
	public <E extends Throwable> void withListener(QueryExecutionListener listener, ThrowingRunnable<E> runnable) {
		this.listeners.add(listener);
		try {
			runnable.run();
		} finally {
			this.listeners.remove(listener);
		}
	}
}
