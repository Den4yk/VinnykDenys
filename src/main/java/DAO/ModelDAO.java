package DAO;

import java.util.List;

public interface ModelDAO<T> {
    T add(T obj);
    T get(long id);
    void delete(long id);
    void update(T obj);
    List<T> getAll();
}
