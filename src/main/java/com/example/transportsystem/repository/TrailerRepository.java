package com.example.transportsystem.repository;

import com.example.transportsystem.model.transport.trailer.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailerRepository extends JpaRepository<Trailer, Long> {
}