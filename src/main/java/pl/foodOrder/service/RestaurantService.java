package pl.foodOrder.service;

import pl.foodOrder.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
    Restaurant save(Restaurant restaurant);
    Restaurant findById(int id);
    void delete(Restaurant restaurant);
    List<Restaurant> findAll();
}
