package model;

import java.time.LocalDateTime;

public class Order {
    int id;
    Restaurant restaurant;
    Client client;
    Food food;
    OrderStatus orderStatus;
    LocalDateTime orderTime;
}


//        restaurant		Restaurant 	/wiele do jednego
//        client			Client	   	/wiele do jednego
//        food	         	Food		/wiele do wielu
