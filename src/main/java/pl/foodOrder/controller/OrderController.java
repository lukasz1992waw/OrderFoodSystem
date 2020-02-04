package pl.foodOrder.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.foodOrder.model.FoodOrder;
import pl.foodOrder.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<FoodOrder>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodOrder> findById(@PathVariable int id){
        return ResponseEntity.ok(orderService.findById(id));
    }

    @DeleteMapping("delete")
    public HttpStatus delete(@RequestBody FoodOrder foodOrder){
        orderService.delete(foodOrder);
        return HttpStatus.OK;
    }
    @GetMapping("/client_orders/{id}")
    public ResponseEntity<List<FoodOrder>> findByFoodOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderService.findAllByClient_Id(id));
    }
}
