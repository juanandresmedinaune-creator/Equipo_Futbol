package com.example.demo.Service;

import com.example.demo.DTO.EntrenadorDTO;
import java.util.List;
import java.util.Optional;

public interface EntrenadorService {
    List<EntrenadorDTO> getAll();
    EntrenadorDTO save(EntrenadorDTO dto);
    Optional<EntrenadorDTO> getById(Long id);
    void delete(Long id);
}