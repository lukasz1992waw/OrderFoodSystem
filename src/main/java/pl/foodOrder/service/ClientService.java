package pl.foodOrder.service;

import pl.foodOrder.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    Client save(Client client);
    Client findById(int id);
    void delete(Client client);
    List<Client> findAll();
}
