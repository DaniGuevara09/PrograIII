package com.example.demo1.persistence;

import java.io.Closeable;
import java.util.List;

public interface InterfaceDAO <T> extends Closeable {

    List<T> getAll();
    T findById(Integer id);
    T save( T object );

    T Delete( Integer id );

    T update (Integer id, T object);
}
