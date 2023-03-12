package com.people.realestate.services;

import java.util.List;

public interface BaseService<T>{
    T create(T t);
    T update(T t);
    void delete(Long id);
    List<T> getAll();
    T findById(Long id);



}
