package org.attestation_final.services;

public interface IMethodsCRUDService<T, V>{
    T create(V dto );
    T update(V dto);
    T delete(Long id);
    T find(Long id);
}
