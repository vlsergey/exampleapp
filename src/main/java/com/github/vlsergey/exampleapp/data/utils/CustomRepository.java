package com.github.vlsergey.exampleapp.data.utils;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    String HINT_CACHEABLE = "org.hibernate.cacheable";

    List<T> findAll(Specification<T> spec);

    Page<T> findAll(Specification<T> spec, Pageable pageable);

    Optional<T> findOne(Specification<T> spec);

    @NonNull
    Class<T> getDomainClass();

    @NonNull
    EntityManager getEntityManager();

    boolean isNew(T entity);

}
