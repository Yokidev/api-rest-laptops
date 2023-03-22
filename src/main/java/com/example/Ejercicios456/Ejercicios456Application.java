package com.example.Ejercicios456;

import com.example.Ejercicios456.entity.Laptop;
import com.example.Ejercicios456.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Ejercicios456Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicios456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		//Creamos los libros
		Laptop laptop1 = new Laptop(null,"Lenovo", "Gaming", 1199.95, LocalDate.of(2020 , 01, 01));
		Laptop laptop2 = new Laptop(null,"Dell", "Sobremesa", 949.95, LocalDate.of(2021 , 01, 01));
		Laptop laptop3 = new Laptop(null,"Hp", "Ofimatica", 650.00, LocalDate.of(2022 , 01, 01));


		//Almacenamos los libros

		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);

	}

}
