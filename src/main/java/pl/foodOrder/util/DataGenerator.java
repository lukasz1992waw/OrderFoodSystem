package pl.foodOrder.util;

import org.springframework.beans.factory.annotation.Autowired;
import pl.foodOrder.dao.ClientDAO;
import pl.foodOrder.dao.FoodDAO;
import pl.foodOrder.dao.OrderDAO;
import pl.foodOrder.dao.RestaurantDAO;
import lombok.Data;
import org.springframework.stereotype.Component;
import pl.foodOrder.model.*;

import java.time.LocalDateTime;
import java.util.Arrays;


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

    public void createData() {
        Client client1 = new Client("Jan", "Kowalski", "Niewiadoma 1, Warszawa");
        Client client2 = new Client("Stefan", "Nowak", "Mickiewicza 2, Poznan");
        Client client3 = new Client("Zdzislaw", "Jankowski", "Domaniewska 4,Krakow");

        Food food1 = new Food(5, FoodType.PIZZA);
        Food food2 = new Food(2, FoodType.HAMBURGER);
        Food food3 = new Food(3, FoodType.SALATKA);
        Food food4 = new Food(6, FoodType.STEK);
        Food food5 = new Food(8, FoodType.PASTA);
        Food food6 = new Food(3, FoodType.HAMBURGER);

        Restaurant restaurant1 = new Restaurant("Pyszna");
        Restaurant restaurant2 = new Restaurant("Bar mleczny");
        Restaurant restaurant3 = new Restaurant("Ristorante");
        Restaurant restaurant4 = new Restaurant("JohnBurg");

        LocalDateTime time1 = LocalDateTime.of(2020, 1, 26, 10, 6, 0);
        LocalDateTime time2 = LocalDateTime.of(2020, 1, 25, 10, 7, 0);
        LocalDateTime time3 = LocalDateTime.of(2020, 1, 24, 10, 8, 0);
        LocalDateTime time4 = LocalDateTime.of(2020, 1, 23, 10, 9, 0);
        LocalDateTime time5 = LocalDateTime.of(2020, 1, 22, 10, 10, 0);
        LocalDateTime time6 = LocalDateTime.of(2020, 1, 21, 10, 11, 0);

        FoodOrder foodOrder1 = new FoodOrder(restaurant1, client1, OrderStatus.NOWE, time1,food1);
        FoodOrder foodOrder2 = new FoodOrder(restaurant2, client2, OrderStatus.NOWE, time2,food2);
        FoodOrder foodOrder3 = new FoodOrder(restaurant3, client3, OrderStatus.NOWE, time3,food3);
        FoodOrder foodOrder4 = new FoodOrder(restaurant4, client1, OrderStatus.NOWE, time4,food4);
        FoodOrder foodOrder5 = new FoodOrder(restaurant1, client2, OrderStatus.NOWE, time5,food5);
        FoodOrder foodOrder6 = new FoodOrder(restaurant2, client3, OrderStatus.NOWE, time6,food6);

        client1.setFoodOrders(Arrays.asList(foodOrder1,foodOrder4));
        client2.setFoodOrders(Arrays.asList(foodOrder2,foodOrder5));
        client3.setFoodOrders(Arrays.asList(foodOrder3,foodOrder6));

        restaurant1.setFoodOrders(Arrays.asList(foodOrder1,foodOrder5));
        restaurant2.setFoodOrders(Arrays.asList(foodOrder2,foodOrder6));
        restaurant3.setFoodOrders(foodOrder3);
        restaurant4.setFoodOrders(foodOrder4);

        clientDAO.save(client1);
        clientDAO.save(client2);
        clientDAO.save(client3);

        restaurantDAO.save(restaurant1);
        restaurantDAO.save(restaurant2);
        restaurantDAO.save(restaurant3);
        restaurantDAO.save(restaurant4);

        orderDAO.save(foodOrder1);
        orderDAO.save(foodOrder2);
        orderDAO.save(foodOrder3);
        orderDAO.save(foodOrder4);
        orderDAO.save(foodOrder5);
        orderDAO.save(foodOrder6);

        food1.setFoodOrder(foodOrder1);
        food2.setFoodOrder(foodOrder2);
        food3.setFoodOrder(foodOrder3);
        food4.setFoodOrder(foodOrder4);
        food5.setFoodOrder(foodOrder5);
        food6.setFoodOrder(foodOrder6);

        foodDAO.save(food1);
        foodDAO.save(food2);
        foodDAO.save(food3);
        foodDAO.save(food4);
        foodDAO.save(food5);
        foodDAO.save(food6);

    }

    public void printAllData() {
        foodDAO.findAll().forEach(System.out::println);
        clientDAO.findAll().forEach(System.out::println);
        orderDAO.findAll().forEach(System.out::println);
        restaurantDAO.findAll().forEach(System.out::println);
    }
}
