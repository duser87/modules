package ru.innopolis.repository;

import ru.innopolis.entity.Client;

import java.util.List;

public interface ClientRepository {

    public List<Client> getAll();

    public void updateClient(String tel, String address, String fio);

    public void addClient(Long id, String fio, String tel, String address);

    public void deleteCLient(String fio);

}

