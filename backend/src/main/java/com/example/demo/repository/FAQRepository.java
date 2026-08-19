package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.FAQ;

public interface FAQRepository extends JpaRepository<FAQ, Long> {
}