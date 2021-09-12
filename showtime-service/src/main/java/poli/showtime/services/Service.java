package poli.showtime.services;

import java.util.List;

public interface Service<T, ID> {
    List<T> findAll();
    T getByID(ID id);
    T save(T t);
    T edit(ID id,T t);
    T delete(ID id);
}
