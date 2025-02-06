package org.datastructures.interfaces;

public interface Manager <T>{

    void add(T t);

    void remove(T t);

    boolean contains(T t);

    T get();

    int size();
}
