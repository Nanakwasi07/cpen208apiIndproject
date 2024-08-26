package com.example.demo.repository;

import com.example.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Long>{
}
