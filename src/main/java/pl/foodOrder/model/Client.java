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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    @OneToMany(mappedBy = "client")
    @JsonManagedReference
    private List<FoodOrder> foodOrders = new ArrayList<>();

    public Client() {
    }

    public Client(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Client(String firstName, String lastName, String address, List<FoodOrder> foodOrders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.foodOrders = foodOrders;
    }

    public Client(String firstName, String lastName, String address, FoodOrder foodOrder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + foodOrders +
                '}';
    }
}
