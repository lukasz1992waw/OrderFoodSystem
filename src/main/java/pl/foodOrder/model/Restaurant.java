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
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "restaurant", fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<FoodOrder> foodOrders = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(String name, List<FoodOrder> foodOrders) {
        this.name = name;
        this.foodOrders = foodOrders;
    }

    public Restaurant(String name, FoodOrder foodOrder) {
        this.name = name;
        this.foodOrders.add(foodOrder);
    }

    public void setFoodOrders(List<FoodOrder> foodOrders) {
        this.foodOrders = foodOrders;
    }

    public void setFoodOrders(FoodOrder foodOrder) {
        this.foodOrders.add(foodOrder);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orders=" + foodOrders +
                '}';
    }
}
