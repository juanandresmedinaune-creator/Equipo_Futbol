package com.example.demo.Service;

import com.example.demo.DTO.PartidoDTO;
import com.example.demo.DTO.PartidoDetalleDTO;
import com.example.demo.Model.Partido;
import com.example.demo.Repository.PartidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidoServiceImpl implements PartidoService {

    private final PartidoRepository repository;

    public PartidoServiceImpl(PartidoRepository repository) {
        this.repository = repository;
    }

    private PartidoDTO toDTO(Partido p) {
        PartidoDTO dto = new PartidoDTO();
        dto.setFecha(p.getFecha());
        dto.setRival(p.getRival());
        dto.setGolesFavor(p.getGolesFavor());
        dto.setGolesContra(p.getGolesContra());
        dto.setEquipoNombre(p.getEquipo() != null ? p.getEquipo().getNombre() : null);
        return dto;
    }

    private Partido toEntity(PartidoDTO dto) {
        Partido p = new Partido();
        p.setFecha(dto.getFecha());
        p.setRival(dto.getRival());
        p.setGolesFavor(dto.getGolesFavor());
        p.setGolesContra(dto.getGolesContra());
        return p;
    }

    @Override
    public List<PartidoDTO> getAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PartidoDTO save(PartidoDTO dto) {
        if (dto == null) throw new IllegalStateException("El partido no puede ser nulo");
        return toDTO(repository.save(toEntity(dto)));
    }

    @Override
    public Optional<PartidoDTO> getById(Long id) {
        Partido partido = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Partido con id " + id + " no existe"));
        return Optional.of(toDTO(partido));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new IllegalStateException("Partido con id " + id + " no existe");
        repository.deleteById(id);
    }

    @Override
    public List<PartidoDetalleDTO> obtenerResultadosConNombres() {
        List<Object[]> resultados = repository.findPartidosConNombresNative();
        return resultados.stream().map(row -> new PartidoDetalleDTO(
                ((Number) row[0]).longValue(), // idPartido
                (String) row[1],               // fecha
                (String) row[2],               // estadio
                (String) row[3],               // nombre equipo local
                (String) row[4],               // nombre equipo visita
                ((Number) row[5]).intValue(),  // goles local
                ((Number) row[6]).intValue()   // goles visita
        )).collect(Collectors.toList());
    }
}