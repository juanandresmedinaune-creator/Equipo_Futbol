package com.example.demo.Service;

import com.example.demo.DTO.EntrenadorDTO;
import com.example.demo.Model.Entrenador;
import com.example.demo.Repository.EntrenadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    private final EntrenadorRepository repository;

    public EntrenadorServiceImpl(EntrenadorRepository repository) {
        this.repository = repository;
    }

    private EntrenadorDTO toDTO(Entrenador e) {
        EntrenadorDTO dto = new EntrenadorDTO();
        dto.setNombre(e.getNombre());
        dto.setEspecialidad(e.getEspecialidad());
        return dto;
    }

    private Entrenador toEntity(EntrenadorDTO dto) {
        Entrenador e = new Entrenador();
        e.setNombre(dto.getNombre());
        e.setEspecialidad(dto.getEspecialidad());
        return e;
    }

    @Override
    public List<EntrenadorDTO> getAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EntrenadorDTO save(EntrenadorDTO dto) {
        if (dto == null) throw new IllegalStateException("El entrenador no puede ser nulo");
        return toDTO(repository.save(toEntity(dto)));
    }

    @Override
    public Optional<EntrenadorDTO> getById(Long id) {
        Entrenador entrenador = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Entrenador con id " + id + " no existe"));
        return Optional.of(toDTO(entrenador));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new IllegalStateException("Entrenador con id " + id + " no existe");
        repository.deleteById(id);
    }
}