package pl.foodOrder.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @JoinColumn(name = "order_id")
    @JsonManagedReference
    private FoodOrder foodOrder;

    public Food() {
    }

    public Food(int amount, FoodType foodType) {
        this.amount = amount;
        this.foodType = foodType;
    }

    public Food(int amount, FoodType foodType, Restaurant restaurant, FoodOrder foodOrder) {
        this.amount = amount;
        this.foodType = foodType;
        this.foodOrder = foodOrder;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", amount=" + amount +
                ", foodType=" + foodType +
                ", orders=" + foodOrder +
                '}';
    }
}
