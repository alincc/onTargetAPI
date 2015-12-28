package com.ontarget.api.dao;

public interface GenericDAO<T> {

    public T insert(T bean);

	public T read(long id);

	public boolean update(T bean);

}
