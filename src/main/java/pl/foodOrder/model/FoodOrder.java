package pl.foodOrder.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDateTime orderTime;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    @OneToMany(mappedBy = "foodOrder", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Food> foods = new ArrayList<>();


    public FoodOrder() {
    }


    public FoodOrder(Restaurant restaurant, Client client, List<Food> foods, OrderStatus orderStatus, LocalDateTime orderTime) {
        this.restaurant = restaurant;
        this.client = client;
        this.foods = foods;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
    }

    public FoodOrder(Restaurant restaurant, Client client, Food food, OrderStatus orderStatus, LocalDateTime orderTime) {
        this.restaurant = restaurant;
        this.client = client;
        this.foods.add(food);
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", client=" + client +
                ", foods=" + foods +
                ", orderStatus=" + orderStatus +
                ", orderTime=" + orderTime +
                '}';
    }
}