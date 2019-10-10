package main.controller;

import main.dto.Client;
import main.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ClientController {

    /**Logica de servicio**/
    @Autowired
    ClientService clientService;

    /**HTTP method GET
     * Request All Clients
     * http://localhost:8080/clients
     * and Client by Id
     * http://localhost:8080/clients/{clientID}
     * **/

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ResponseEntity<Client> getAllClients() {
        Iterable<Client> clientList = clientService.getAllClients();
        return new ResponseEntity(clientList, HttpStatus.OK);
    }

    @RequestMapping(value="/clients/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Client> getClientById(@PathVariable long clientId) {
        Client clientById = clientService.getClientById(clientId);
        return new ResponseEntity<>(clientById, HttpStatus.OK);
    }

    /**HTTP method POST
     * http://localhost:8080/clients/
     * **/

    @RequestMapping(value="/clients", method = RequestMethod.POST)
    public ResponseEntity<?> addClient(@RequestBody @Valid Client client) {
        Client newClient = clientService.addClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    /** HTTP method UPDATE
     * http://localhost:8080/clients
     * **/

    @RequestMapping(value="/clients/{clientId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateClient(@PathVariable long clientId, @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(clientId, client);
        return new ResponseEntity<>(updatedClient, HttpStatus.ACCEPTED);
    }

    /**HTTP method Delete
     * http://localhost:8080/clients **/

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(@PathVariable long clientId) {
        Client clientToDelete = clientService.getClientById(clientId);
        clientService.deleteClient(clientToDelete);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}


