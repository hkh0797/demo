package com.example.demo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SideRepository extends JpaRepository<SideEntity, Long> {
    List<SideEntity> findAllByOrderByIdAsc();
}
