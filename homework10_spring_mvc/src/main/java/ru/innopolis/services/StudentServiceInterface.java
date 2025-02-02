package ru.innopolis.services;

import ru.innopolis.models.Student;

public interface StudentServiceInterface<T, V> {

    public T create(T t) throws Exception;
    public T update(T t) throws Exception;
    public V delete(Long id);
    public T findById(Long id) throws Exception;

}
