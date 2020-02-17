package pl.foodOrder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import pl.foodOrder.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.foodOrder.model.Food;
import pl.foodOrder.model.FoodOrder;
import pl.foodOrder.service.ClientService;
import pl.foodOrder.service.FoodService;
import pl.foodOrder.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    ClientService clientService;
    FoodService foodService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/clientLogin", method = RequestMethod.GET)
    public String showClientLogin(Model model) {
        return "clientLogin";
    }

    @RequestMapping(value = "/createClient", method = RequestMethod.GET)
    public String showCreateClient(Model model) {
        return "createClient";
    }

    @RequestMapping(value = "/findClientResult", method = RequestMethod.POST)
    public String findResult(@RequestParam int id, Model model) {
        Client client = this.clientService.findById(id);
        model.addAttribute("clientResult", client);
        return "findClientResult";
    }

















//    @RequestMapping(value = "/clientLogin", method = RequestMethod.GET)
//    public String showClientLogin(Model model) {
//        model.addAttribute("bmiModel", new Client());
//        return "clientLoginView";
//    }

    @RequestMapping(value = "/clientPanel", method = RequestMethod.POST)
    public String getForm(@ModelAttribute Client clientModel, Model model) {
        int id = clientModel.getId();
        return "clientPanel";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable int id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Client> findById(@PathVariable int id) {
//        return ResponseEntity.ok(clientService.findById(id));
//    }

    @DeleteMapping("delete")
    public HttpStatus delete(@RequestBody Client client) {
        clientService.delete(client);
        return HttpStatus.OK;
    }

    @GetMapping("/{id2}")
    public ResponseEntity<Food> findFoodById(@PathVariable int id2) {
        return ResponseEntity.ok(foodService.findById(id2));
    }
}
