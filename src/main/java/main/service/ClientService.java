package main.service;

import main.dto.Client;
import main.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**Inicio de la lógica de servicio**/

    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(long clientId) {
        return clientRepository.findById(clientId).get();
    }

    public Client updateClient(long clientId, Client client) {
        Client updatedClient = clientRepository.save(client);
        return updatedClient;
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public Client addClient(Client client) {
        Client newClient = clientRepository.save(client);
        return newClient;
    }

}
