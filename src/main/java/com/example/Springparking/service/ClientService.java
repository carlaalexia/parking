package com.example.Springparking.service;

import com.example.Springparking.entity.Client;

public interface ClientService {

    public Iterable<Client> getAllClients();

    public Client createClient(Client clientForm) throws Exception;

}
