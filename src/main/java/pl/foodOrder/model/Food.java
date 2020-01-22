package pl.foodOrder.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    @Enumerated(value = EnumType.STRING)
    private FoodType foodType;

    @ManyToOne
    @JoinColumn(name = "food_id_")
    @JsonManagedReference
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "food_id")
    @JsonManagedReference
    private Order order;

    public Food() {
    }

    public Food(int amount, FoodType foodType, Restaurant restaurant, Order order) {
        this.amount = amount;
        this.foodType = foodType;
        this.restaurant = restaurant;
        this.order = order;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", amount=" + amount +
                ", foodType=" + foodType +
                ", restaurant=" + restaurant +
                ", orders=" + order +
                '}';
    }
}
