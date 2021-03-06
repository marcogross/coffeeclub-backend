package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {

}
