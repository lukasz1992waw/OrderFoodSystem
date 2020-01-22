package pl.foodOrder.service.impl;

import pl.foodOrder.dao.ClientDAO;
import pl.foodOrder.model.Client;
import org.springframework.stereotype.Service;
import pl.foodOrder.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    ClientDAO clientDAO;
    @Override
    public Client save(Client client) {
        return clientDAO.save(client);
    }

    @Override
    public Client findById(int id) {
        return clientDAO.findById(id);
    }

    @Override
    public void delete(Client client) {
        clientDAO.delete(client);
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }
}
