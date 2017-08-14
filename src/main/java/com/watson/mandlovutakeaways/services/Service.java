package com.watson.mandlovutakeaways.services;


/**
 * Created by Long on 8/14/2017.
 */
public interface Service<E,ID> {
    E create(E entity);

    E readById(ID id);

    Iterable<E> readAll();

    E update(E entity);

    void delete(E entity);
}
