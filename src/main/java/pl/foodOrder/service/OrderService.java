package pl.foodOrder.service;

import pl.foodOrder.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order findById(int id);
    Order save(Order order);
    void delete(Order order);
    List<Order> findAll();
}
