package com.github.vlsergey.exampleapp.data.utils;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import lombok.Getter;
import lombok.NonNull;

@NoRepositoryBean
public class CustomRepositoryImpl<T, I extends Serializable> extends SimpleJpaRepository<T, I>
		implements CustomRepository<T, I> {

	@Getter
	private final @NonNull JpaEntityInformation<T, I> entityInformation;

	@Getter
	private final @NonNull EntityManager entityManager;

	public CustomRepositoryImpl(final @NonNull JpaEntityInformation<T, I> entityInformation,
			final @NonNull EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
	}

	@Override
	public Class<T> getDomainClass() {
		return super.getDomainClass();
	}

	@Override
	public boolean isNew(T entity) {
		return entityInformation.isNew(entity);
	}

}