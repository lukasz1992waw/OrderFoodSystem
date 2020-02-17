package pl.foodOrder.controller;

import org.springframework.stereotype.Controller;
import pl.foodOrder.model.Client;
import pl.foodOrder.model.Food;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.foodOrder.model.FoodOrder;
import pl.foodOrder.service.FoodService;

import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


















    @GetMapping("/list")
    public ResponseEntity<List<Food>> findAll(){
        return ResponseEntity.ok(foodService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> findById(@PathVariable int id){
        return ResponseEntity.ok(foodService.findById(id));
    }

    @DeleteMapping("delete")
    public HttpStatus delete(@RequestBody Food food){
        foodService.delete(food);
        return HttpStatus.OK;
    }

    @GetMapping("/byOrder/{id}")
    public ResponseEntity<List<Food>> findByFoodOrder(@PathVariable int id) {
        return ResponseEntity.ok(foodService.findAllByOrderId(id));
    }
}
