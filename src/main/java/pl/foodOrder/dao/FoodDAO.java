package pl.foodOrder.dao;

import org.springframework.data.repository.CrudRepository;
import pl.foodOrder.model.Client;
import pl.foodOrder.model.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDAO extends CrudRepository<Food, Integer> {
    Food findById(int id);
    Food save(Food food);
    void delete(Food food);
    List<Food> findAll();
}
