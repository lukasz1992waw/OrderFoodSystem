package pl.foodOrder.controller;

import org.springframework.stereotype.Controller;
import pl.foodOrder.model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.foodOrder.service.RestaurantService;

import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Restaurant>> findAll(){
        return ResponseEntity.ok(restaurantService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable int id){
        return ResponseEntity.ok(restaurantService.findById(id));
    }

    @DeleteMapping("delete")
    public HttpStatus delete(@RequestBody Restaurant restaurant){
        restaurantService.delete(restaurant);
        return HttpStatus.OK;
    }
}
