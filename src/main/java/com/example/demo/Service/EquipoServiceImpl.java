package com.example.demo.Service;

import com.example.demo.DTO.EquipoDTO;
import com.example.demo.Model.Equipo;
import com.example.demo.Repository.EquipoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository repository;

    public EquipoServiceImpl(EquipoRepository repository) {
        this.repository = repository;
    }

    private EquipoDTO toDTO(Equipo e) {
        EquipoDTO dto = new EquipoDTO();
        dto.setNombre(e.getNombre());
        dto.setCiudad(e.getCiudad());
        dto.setAnioFundacion(e.getAnioFundacion());
        dto.setEntrenadorNombre(e.getEntrenador() != null ? e.getEntrenador().getNombre() : null);
        return dto;
    }

    private Equipo toEntity(EquipoDTO dto) {
        Equipo e = new Equipo();
        e.setNombre(dto.getNombre());
        e.setCiudad(dto.getCiudad());
        e.setAnioFundacion(dto.getAnioFundacion());
        return e;
    }

    @Override
    public List<EquipoDTO> getAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoDTO save(EquipoDTO dto) {
        if (dto == null) throw new IllegalStateException("El equipo no puede ser nulo");
        return toDTO(repository.save(toEntity(dto)));
    }

    @Override
    public Optional<EquipoDTO> getById(Long id) {
        Equipo equipo = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Equipo con id " + id + " no existe"));
        return Optional.of(toDTO(equipo));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new IllegalStateException("Equipo con id " + id + " no existe");
        repository.deleteById(id);
    }
}