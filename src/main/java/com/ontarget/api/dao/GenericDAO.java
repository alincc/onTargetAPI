package com.ontarget.api.dao;

public interface GenericDAO<T> {
	T insert(T bean);
	T read(long id);
	boolean update(T bean);
}
