package com.api.admin.services;

import java.util.List;

public interface ICrudServices<T,E> {
	
	public List<T> findAll();
	public T findById(E id);
	public T save(T entity);
	public T edit(T entity, E id);
	public void delete(E id);
}
