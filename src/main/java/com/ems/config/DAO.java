package com.ems.config;

import com.ems.model.Employee;

import java.util.List;

public interface DAO<T> {
    //Create
    public void save(T object);

    //Read
    public T getById(int id);

    //Update
    public void update(T object);

    //Delete
    public void deleteById(int id);

    //Get All
    public List<T> getAll();
}
