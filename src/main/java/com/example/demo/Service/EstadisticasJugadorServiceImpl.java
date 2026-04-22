package com.example.demo.Service;

import com.example.demo.DTO.EstadisticasJugadorDTO;
import com.example.demo.Model.EstadisticasJugador;
import com.example.demo.Repository.EstadisticasJugadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadisticasJugadorServiceImpl implements EstadisticasJugadorService {

    private final EstadisticasJugadorRepository repository;

    public EstadisticasJugadorServiceImpl(EstadisticasJugadorRepository repository) {
        this.repository = repository;
    }

    private EstadisticasJugadorDTO toDTO(EstadisticasJugador e) {
        EstadisticasJugadorDTO dto = new EstadisticasJugadorDTO();
        dto.setPartidosJugados(e.getPartidosJugados());
        dto.setGoles(e.getGoles());
        dto.setAsistencias(e.getAsistencias());
        dto.setTarjetasAmarillas(e.getTarjetasAmarillas());
        dto.setTarjetasRojas(e.getTarjetasRojas());
        dto.setJugadorNombre(e.getJugador() != null ? e.getJugador().getNombre() : null);
        return dto;
    }

    private EstadisticasJugador toEntity(EstadisticasJugadorDTO dto) {
        EstadisticasJugador e = new EstadisticasJugador();
        e.setPartidosJugados(dto.getPartidosJugados());
        e.setGoles(dto.getGoles());
        e.setAsistencias(dto.getAsistencias());
        e.setTarjetasAmarillas(dto.getTarjetasAmarillas());
        e.setTarjetasRojas(dto.getTarjetasRojas());
        return e;
    }

    @Override
    public List<EstadisticasJugadorDTO> getAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstadisticasJugadorDTO save(EstadisticasJugadorDTO dto) {
        if (dto == null) throw new IllegalStateException("Las estadísticas no pueden ser nulas");
        return toDTO(repository.save(toEntity(dto)));
    }

    @Override
    public Optional<EstadisticasJugadorDTO> getById(Long id) {
        EstadisticasJugador estadisticas = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Estadísticas con id " + id + " no existen"));
        return Optional.of(toDTO(estadisticas));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new IllegalStateException("Estadísticas con id " + id + " no existen");
        repository.deleteById(id);
    }
}