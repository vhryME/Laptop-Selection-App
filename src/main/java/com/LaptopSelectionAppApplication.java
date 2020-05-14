package com;

import com.model.Laptop;
import com.model.Parser;
import com.reps.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LaptopSelectionAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(LaptopSelectionAppApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner demo(LaptopRepository repository) {
		return (args) -> {
			List<Laptop> laptops = Parser.getProducts();

			for(Laptop laptop : laptops)
				repository.save(laptop);
		};
	}
}
