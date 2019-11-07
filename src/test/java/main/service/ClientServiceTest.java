package main.service;

import main.dto.Client;
import main.repository.ClientRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class ClientServiceTest {

    @InjectMocks
    ClientService clientService;

    @Mock
    ClientRepository clientRepository;
    Client client;


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        client = new Client();
        client.setId(1);
        client.setFirstName("Mario");
        client.setLastName("Milano");
        client.setDocumentNumber(509888);
        client.setAddress("CABA");
        client.setQuantityOfPurchases(3);
    }

    @Test
    public void getClientByIdTest() {

        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(client));
        Client client1 = clientService.getClientById(1);
        assertNotNull(client1);
        assertEquals("Milano", client1.getLastName());
    }

    @Test
    public void updateClient() {
    }

    @Test
    public void deleteClient() {
    }

    @Test
    public void addClient() {
    }
}