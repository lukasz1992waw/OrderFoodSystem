package pl.foodOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.foodOrder.util.DataGenerator;

@Controller
public class DataController {
    DataGenerator dataGenerator;

    @Autowired
    public DataController(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
        dataGenerator.createData();
//        dataGenerator.printAllData();
    }
}
