package com.example.demo.Service;

import com.example.demo.DTO.JugadorDTO;
import java.util.List;
import java.util.Optional;

public interface JugadorService {
    List<JugadorDTO> getAll();
    JugadorDTO save(JugadorDTO dto);
    Optional<JugadorDTO> getById(Long id);
    void delete(Long id);
    List<JugadorDTO> getJugadoresByEquipo(Long equipoId);
    List<JugadorDTO> obtenerGoleadores(int minGoles);
}