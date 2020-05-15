package com.controllers;


import com.model.Laptop;
import com.model.Parser;
import com.reps.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RestAPIController {
    @Autowired
    LaptopRepository repository;
    List<Laptop> laptops = Parser.getProducts();

    @RequestMapping (value = "/add_all", method = RequestMethod.GET)
    public void addAll() {
        for(Laptop laptop : laptops) {
            repository.save(laptop);
        }
    }
}
