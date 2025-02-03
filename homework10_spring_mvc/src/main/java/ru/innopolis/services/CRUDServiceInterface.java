package ru.innopolis.services;

import java.util.List;

public interface CRUDServiceInterface<T, S> {

    public T create(T t) throws Exception;
    public T update(T t) throws Exception;
    public S delete(Long id);
    public T findById(Long id) throws Exception;

}
