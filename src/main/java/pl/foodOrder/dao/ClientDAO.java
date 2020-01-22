package pl.foodOrder.dao;

import org.springframework.data.repository.CrudRepository;
import pl.foodOrder.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDAO extends CrudRepository<Client, Integer> {
    Client save(Client client);
    Client findById(int id);
    void delete(Client client);
    List<Client> findAll();
}
