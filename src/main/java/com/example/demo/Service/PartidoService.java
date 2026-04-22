package com.example.demo.Service;

import com.example.demo.DTO.PartidoDTO;
import java.util.List;
import java.util.Optional;

public interface PartidoService {
    List<PartidoDTO> getAll();
    PartidoDTO save(PartidoDTO dto);
    Optional<PartidoDTO> getById(Long id);
    void delete(Long id);
}