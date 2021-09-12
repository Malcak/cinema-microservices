package poli.user.services;

import java.util.List;

public interface Service<T, ID> {
    List<T> findAll();
    T getById(ID id);
    T save(T t);
    T delete(ID id);
}
