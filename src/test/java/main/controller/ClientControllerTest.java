package main.controller;

import main.dto.Client;
import main.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class ClientControllerTest {

    @InjectMocks
    ClientController clientController;

    @Mock
    ClientService clientService;
    Client client;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        client = new Client();
        client.setId(2);
        client.setFirstName("Monica");
        client.setLastName("Bush");
        client.setAddress("Buenos Aires");
        client.setDocumentNumber(123456);
        client.setQuantityOfPurchases(5);

    }

    @Test
    final void testGetClientById() {
        when(clientService.getClientById(anyLong())).thenReturn(client);

        Client clientById = clientService.getClientById(2);

        assertNotNull(clientById);
        assertEquals(2, clientById.getId());
        assertEquals(client.getFirstName(), clientById.getFirstName());
        assertEquals(client.getLastName(), clientById.getLastName());

    }



}