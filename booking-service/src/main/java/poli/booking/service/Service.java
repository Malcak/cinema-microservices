package poli.booking.service;

import java.util.List;

public interface Service<T, ID> {
    List<T> findAll();
    T getById(ID id);
    List<T> getAllByUserId(Long id);
    T save(T t);
    T delete(ID id);
}
