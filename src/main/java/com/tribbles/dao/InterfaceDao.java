package com.tribbles.dao;

/**
 *  Interface used for all DAOs
 * @param <T>   Entity
 * @param <I>   Primary id
 */
public interface InterfaceDao<T, I> {

    int save(T t);
    int read(I id);
    int update(T t);
    int delete(I id);
}
