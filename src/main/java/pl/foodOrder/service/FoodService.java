package pl.foodOrder.service;

import pl.foodOrder.model.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    Food findById(int id);
    Food save(Food food);
    void delete(Food food);
    List<Food> findAll();
}
