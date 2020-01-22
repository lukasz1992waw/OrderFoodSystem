package pl.foodOrder.controller;

import pl.foodOrder.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.foodOrder.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable int id){
        return ResponseEntity.ok(orderService.findById(id));
    }

    @DeleteMapping("delete")
    public HttpStatus delete(@RequestBody Order order){
        orderService.delete(order);
        return HttpStatus.OK;
    }
}
