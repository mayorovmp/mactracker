package com.mactracker.repository;

import com.mactracker.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Seller, Long> {
}
