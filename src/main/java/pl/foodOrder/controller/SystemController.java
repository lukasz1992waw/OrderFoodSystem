package pl.foodOrder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.foodOrder.model.Client;

@Controller
@RequestMapping("/index")
public class SystemController {

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String showIndex(Model model) {
        return "index";
    }


}
