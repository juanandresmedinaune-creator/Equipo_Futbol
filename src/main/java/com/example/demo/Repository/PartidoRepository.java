package com.example.demo.Repository;

import com.example.demo.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository extends JpaRepository<Partido, Long> {}