package DAO;

import java.sql.SQLException;

public interface ModelDAO<T> {
    void add(T obj) throws SQLException;
    T get(long id) throws SQLException;
    void delete(long id) throws SQLException;
}
