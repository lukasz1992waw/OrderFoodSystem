package pl.foodOrder.dao;

import org.springframework.data.repository.CrudRepository;
import pl.foodOrder.model.Client;
import pl.foodOrder.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantDAO extends CrudRepository<Restaurant, Integer> {
    Restaurant save(Restaurant restaurant);
    Restaurant findById(int id);
    void delete(Restaurant restaurant);
    List<Restaurant> findAll();
}
