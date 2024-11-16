package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Models.Reclamo;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {
}
