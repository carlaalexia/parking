package com.example.Springparking.service;

import com.example.Springparking.entity.Client;
import com.example.Springparking.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    ClientRepository clienteRepositorio;

    @Override
    public Iterable<Client> getAllClients() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Client createClient(Client client) throws Exception {
        client = clienteRepositorio.save(client);

        return client;
    }




}
