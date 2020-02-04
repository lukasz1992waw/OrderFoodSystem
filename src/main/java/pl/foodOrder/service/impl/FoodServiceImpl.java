package pl.foodOrder.service.impl;

import org.springframework.stereotype.Service;

import pl.foodOrder.dao.FoodDAO;
import pl.foodOrder.model.Food;
import pl.foodOrder.service.FoodService;


import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{
    FoodDAO foodDAO;

    public FoodServiceImpl(FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }

    @Override
    public Food findById(int id) {
        return foodDAO.findById(id);
    }

    @Override
    public Food save(Food food) {
        return foodDAO.save(food);
    }

    @Override
    public void delete(Food food) {
        foodDAO.delete(food);
    }

    @Override
    public List<Food> findAll() {
        return foodDAO.findAll();
    }

    @Override
    public List<Food> findAllByOrderId(int id) {
        return foodDAO.findAllByFoodOrder_Id(id);
    }
}
