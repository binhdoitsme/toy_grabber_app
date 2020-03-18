package com.toygrabber.base.repository;

import java.io.Serializable;
import java.util.Collection;

public interface Repository<T, ID extends Serializable> {
	<S extends T> S save(S entity);
	T findOne(ID primaryKey);
	Collection<T> findAll();
	Long count();
	void delete(T entity);
	boolean exists(ID primaryKey);
}
