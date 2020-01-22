package com.bank.repository;

import java.util.List;

public interface CrudRepository<E> {
    //creat
    boolean save(E entity);

    //read
    E findById(Integer id);

    List<E> findAll();

    //update

    void update(E entity);

    //
    void deleteById(Integer id);
}