package pl.foodOrder.service;
import org.springframework.stereotype.Service;
import pl.foodOrder.model.Client;
import pl.foodOrder.model.Food;
import pl.foodOrder.model.FoodOrder;

import java.util.List;

@Service
public interface OrderService {
    FoodOrder findById(int id);
    FoodOrder save(FoodOrder foodOrder);
    void delete(FoodOrder foodOrder);
    List<FoodOrder> findAll();
    List<FoodOrder> findAllByClient_Id(int id);
}
