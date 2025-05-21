package dao;

import java.util.List;

public interface DAO<T> {
    void insert(T t);

    void update(T t);

    List<T> findAll();

    T findById(int id);

    void deleteById(int id);
}
