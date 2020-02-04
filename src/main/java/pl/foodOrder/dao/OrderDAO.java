package pl.foodOrder.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.foodOrder.model.FoodOrder;
import pl.foodOrder.model.OrderStatus;

import java.util.List;

@Repository
public interface OrderDAO extends CrudRepository<FoodOrder, Integer> {
    FoodOrder findById(int id);
    FoodOrder save(FoodOrder orderFoodOrder);
    void delete(FoodOrder orderFoodOrder);
    List<FoodOrder> findAll();
    List<FoodOrder> findAllByClient_Id(int id);
    List<FoodOrder> findAllByClient_IdAndOrderStatus(int id, OrderStatus orderStatus);
    List<FoodOrder> findAllByRestaurantId(int id);


}
