package com.app.Daos;

import java.util.List;


public interface DaoMain<E,K> {
    abstract public void insert(E entity);
    abstract public void update(E entity);
    abstract public void delete(K key);
     abstract public List<E> selectAll();
    abstract public E selectById(K key);
    abstract public List<E> selectBySql(String sql , Object...args);

}
