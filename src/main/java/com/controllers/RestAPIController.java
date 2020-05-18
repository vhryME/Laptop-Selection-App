package com.controllers;


import com.model.Laptop;
import com.parser.Parser;
import com.reps.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Equals @Controller but you don't have to writing @ResponseBody
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


    @RequestMapping(value = "get_all", method = RequestMethod.GET)
    public List<Laptop> getAll() {
        return laptops;
    }


    @RequestMapping(value = "get_cheap", method = RequestMethod.GET)
    public List<Laptop> getCheapLaptopsRest() {
        List<Laptop> cheapLaptops = Parser.getCheapLaptops(laptops);

        return cheapLaptops;
    }


    @RequestMapping(value = "get_power", method = RequestMethod.GET)
    public List<Laptop> getPowerfullLaptopsRest() {
        List<Laptop> powerfullLaptops = Parser.getPowerfullLaptops(laptops);

        return powerfullLaptops;
    }


    @RequestMapping(value = "get_laptop", method = RequestMethod.GET)
    public Laptop getByCode(@RequestParam String code) {
        for(Laptop laptop : laptops) {
            if(laptop.getCode().equals(code))
                return laptop;
        }

        return null;
    }
}
