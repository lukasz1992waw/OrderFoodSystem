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

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    private List<Food> foods = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String name, List<Food> foods, List<Order> orders) {
        this.name = name;
        this.foods = foods;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foods=" + foods +
                ", orders=" + orders +
                '}';
    }
}
