package org.attestation_final.services;

/**
 * Интерфейс, определяющий стандартные CRUD-операции
 */
public interface IMethodsCRUDService<T, V>{
    T create(V dto );
    T update(V dto);
    T delete(Long id);
    T find(Long id);
}
