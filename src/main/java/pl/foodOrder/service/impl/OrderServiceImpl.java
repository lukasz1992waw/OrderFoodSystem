package pl.foodOrder.service.impl;

import pl.foodOrder.dao.OrderDAO;
import pl.foodOrder.model.Order;
import org.springframework.stereotype.Service;
import pl.foodOrder.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    OrderDAO orderDAO;
    @Override
    public Order findById(int id) {
        return orderDAO.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderDAO.save(order);
    }

    @Override
    public void delete(Order order) {
        orderDAO.delete(order);
    }

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }
}
