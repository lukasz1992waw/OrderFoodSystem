package pl.foodOrder.util;

import org.springframework.beans.factory.annotation.Autowired;
import pl.foodOrder.dao.ClientDAO;
import pl.foodOrder.dao.FoodDAO;
import pl.foodOrder.dao.OrderDAO;
import pl.foodOrder.dao.RestaurantDAO;
import lombok.Data;
import pl.foodOrder.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class DataGenerator {

    ClientDAO clientDAO;
    FoodDAO foodDAO;
    OrderDAO orderDAO;
    RestaurantDAO restaurantDAO;

    public DataGenerator(ClientDAO clientDAO, FoodDAO foodDAO, OrderDAO orderDAO, RestaurantDAO restaurantDAO) {
        this.clientDAO = clientDAO;
        this.foodDAO = foodDAO;
        this.orderDAO = orderDAO;
        this.restaurantDAO = restaurantDAO;
    }

    public void createData(){
        Order order1 = new Order();
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        Client client1 = new Client("Jan","Kowalski","Niewiadoma 5",orders);
        clientDAO.save(client1);


//        Food food1 = new Food(10, FoodType.PIZZA,restaurant1,order1);
//        List<Food> foods = new ArrayList<>();
//        foods.add(food1);
//        Restaurant restaurant1= new Restaurant("Pyszna",foods,)
    }
}
