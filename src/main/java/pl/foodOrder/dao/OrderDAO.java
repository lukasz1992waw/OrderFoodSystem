package pl.foodOrder.dao;

import org.springframework.data.repository.CrudRepository;
import pl.foodOrder.model.Client;
import pl.foodOrder.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends CrudRepository<Order, Integer> {
    Order findById(int id);
    Order save(Order order);
    void delete(Order order);
    List<Order> findAll();
}
