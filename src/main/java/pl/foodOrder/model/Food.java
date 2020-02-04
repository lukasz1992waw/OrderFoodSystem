package pl.foodOrder.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @JoinColumn(name = "foodOrder_id")
    @JsonBackReference
    private FoodOrder foodOrder;

    public Food() {
    }

    public Food(int amount, FoodType foodType, FoodOrder foodOrder) {
        this.amount = amount;
        this.foodType = foodType;
        this.foodOrder= foodOrder;
    }

    public Food(int amount, FoodType foodType) {
        this.amount = amount;
        this.foodType = foodType;
    }

    public void setFoodOrder(FoodOrder foodOrder) {
        this.foodOrder = foodOrder;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", amount=" + amount +
                ", foodType=" + foodType +
                '}';
    }
}
