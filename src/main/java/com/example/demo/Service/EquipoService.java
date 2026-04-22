package com.example.demo.Service;

import com.example.demo.DTO.EquipoDTO;
import java.util.List;
import java.util.Optional;

public interface EquipoService {
    List<EquipoDTO> getAll();
    EquipoDTO save(EquipoDTO dto);
    Optional<EquipoDTO> getById(Long id);
    void delete(Long id);
}