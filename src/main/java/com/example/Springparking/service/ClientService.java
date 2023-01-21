package com.example.Springparking.service;

import com.example.Springparking.entity.Client;

public interface ClientService {

    public Iterable<Client> getAllClients();

    public Client createClient(Client client) throws Exception;

    public Client getUserById(Long id) throws Exception;

    public Client updateClient(Client client) throws Exception;

    public void deleteClient(Long id) throws Exception;



}
