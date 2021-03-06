package pl.foodOrder.service.impl;

import pl.foodOrder.dao.OrderDAO;
import pl.foodOrder.model.Client;
import pl.foodOrder.model.FoodOrder;
import org.springframework.stereotype.Service;
import pl.foodOrder.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public FoodOrder findById(int id) {
        return orderDAO.findById(id);
    }

    @Override
    public FoodOrder save(FoodOrder foodOrder) {
        return orderDAO.save(foodOrder);
    }

    @Override
    public void delete(FoodOrder foodOrder) {
        orderDAO.delete(foodOrder);
    }

    @Override
    public List<FoodOrder> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public List<FoodOrder> findAllByClient_Id(int id) {
        return orderDAO.findAllByClient_Id(id);
    }
}
