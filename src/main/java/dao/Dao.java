package dao;

import java.util.List;

public interface Dao<T> {
	public int create(T obj); // grava

	public List<T> read(); // seleciona todos

        
	
	

}
