package com.github.vlsergey.exampleapp.data.utils;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>
		extends CustomRepository<T, ID>, QuerydslPredicateExecutor<T> {

	@Override
	List<T> findAll(Predicate predicate);

	@Override
	List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);

}
