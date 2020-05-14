package com.reps;


import com.model.Laptop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface LaptopRepository extends CrudRepository<Laptop, Integer> {
    List<Laptop> getAll();
    Laptop getByCode();
}
