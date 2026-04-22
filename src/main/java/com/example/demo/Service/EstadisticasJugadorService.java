package com.example.demo.Service;

import com.example.demo.DTO.EstadisticasJugadorDTO;
import java.util.List;
import java.util.Optional;

public interface EstadisticasJugadorService {
    List<EstadisticasJugadorDTO> getAll();
    EstadisticasJugadorDTO save(EstadisticasJugadorDTO dto);
    Optional<EstadisticasJugadorDTO> getById(Long id);
    void delete(Long id);
}