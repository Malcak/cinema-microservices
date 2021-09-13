package poli.user.services;

import poli.user.entities.User;

import java.util.List;

public interface Service<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T t);
    T delete(ID id);
}
