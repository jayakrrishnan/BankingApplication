package com.training.ifaces;

import java.util.List;


public interface GenericDao<T> {

	public long add(T t);
	public long update(long key,String accountType,String passWord);
	public long delete(long key);
	public T findById(long key);
	public List<T> findAll();
}
   