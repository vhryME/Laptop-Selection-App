package com.reps;


import com.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
    /*List<Laptop> getAll();
    Laptop getByCode();*/
}
