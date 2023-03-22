package com.example.Ejercicios456.repository;

import com.example.Ejercicios456.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}
