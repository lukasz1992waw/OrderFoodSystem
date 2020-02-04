package pl.foodOrder.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
    @OneToMany(mappedBy = "foodOrder",fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<Food> foods= new ArrayList<>();

    public FoodOrder() {
    }

    public FoodOrder(Restaurant restaurant, Client client,OrderStatus orderStatus, LocalDateTime orderTime, List<Food> foods) {
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
        this.restaurant = restaurant;
        this.client = client;
        this.foods = foods;
    }

    public FoodOrder(Restaurant restaurant, Client client,OrderStatus orderStatus, LocalDateTime orderTime,Food food) {
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
        this.restaurant = restaurant;
        this.client = client;
        this.foods.add(food);
    }

    public FoodOrder(Restaurant restaurant, Client client, OrderStatus orderStatus, LocalDateTime orderTime) {
        this.restaurant = restaurant;
        this.client = client;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", client=" + client +
                ", orderStatus=" + orderStatus +
                ", orderTime=" + orderTime +
                '}';
    }
}