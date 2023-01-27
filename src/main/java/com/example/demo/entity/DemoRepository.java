package com.example.demo.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<DemoEntity, Long> {
    Page<DemoEntity> findAllByOrderByIdxDesc(Pageable pageable);
}
