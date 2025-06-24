package org.attestation_final.clients;

/**
 * Интерфейс, определяющий метод получения данных по сети от дугого сервиса
 */
public interface IGetDataRest<T>{
    T findByIdREST(Long id);
}
