package pl.foodOrder.controller;

import org.springframework.stereotype.Controller;
import pl.foodOrder.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.foodOrder.service.ClientService;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable int id){
        return ResponseEntity.ok(clientService.findById(id));
    }

    @DeleteMapping("delete")
    public HttpStatus delete(@RequestBody Client client){
        clientService.delete(client);
        return HttpStatus.OK;
    }

}
