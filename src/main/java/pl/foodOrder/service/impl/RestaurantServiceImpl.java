package pl.foodOrder.service.impl;

import pl.foodOrder.dao.RestaurantDAO;
import pl.foodOrder.model.Restaurant;
import org.springframework.stereotype.Service;
import pl.foodOrder.service.RestaurantService;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    RestaurantDAO restaurantDAO;
    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantDAO.save(restaurant);
    }

    @Override
    public Restaurant findById(int id) {
        return restaurantDAO.findById(id);
    }

    @Override
    public void delete(Restaurant restaurant) {
        restaurantDAO.delete(restaurant);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantDAO.findAll();
    }
}
