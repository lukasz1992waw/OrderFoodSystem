package pl.foodOrder.model;
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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonManagedReference
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonManagedReference
    private Client client;

    @OneToMany(mappedBy = "order", fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<Food> foods = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime orderTime;

    public Order() {
    }

    public Order(Restaurant restaurant, Client client, List<Food> foods, OrderStatus orderStatus, LocalDateTime orderTime) {
        this.restaurant = restaurant;
        this.client = client;
        this.foods = foods;
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

