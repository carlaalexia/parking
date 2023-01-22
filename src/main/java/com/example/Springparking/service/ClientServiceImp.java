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

    @Override
    public Client getUserById(Long id) throws Exception {
        Client client = clienteRepositorio.findById(id).orElseThrow(() -> new Exception("User does not exist"));
        return client;
    }
    @Override
    public Client updateClient(Client fromClient) throws Exception {
        Client toClient = getUserById(fromClient.getId());
        mapClient(fromClient, toClient);
        return clienteRepositorio.save(toClient);
    }



    protected void mapClient(Client from,Client to) {
        to.setNombrePropietario(from.getNombrePropietario());
        to.setApellidoPropietario(from.getApellidoPropietario());
        to.setModeloAuto(from.getModeloAuto());
        to.setHoraLlegada(from.getHoraLlegada());
        to.setHoraSalida(from.getHoraSalida());
    }

    public void deleteClient(Long id) throws Exception {
        Client client = clienteRepositorio.findById(id)
                .orElseThrow(() -> new Exception("ClientnotFound in deleteClient -"+this.getClass().getName()));

        clienteRepositorio.delete(client);
    }
}
