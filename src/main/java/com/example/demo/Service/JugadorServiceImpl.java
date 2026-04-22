package com.example.demo.Service;

import com.example.demo.DTO.JugadorDTO;
import com.example.demo.Model.Jugador;
import com.example.demo.Repository.JugadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorServiceImpl implements JugadorService {

    private final JugadorRepository repository;

    public JugadorServiceImpl(JugadorRepository repository) {
        this.repository = repository;
    }

    private JugadorDTO toDTO(Jugador j) {
        JugadorDTO dto = new JugadorDTO();
        dto.setNombre(j.getNombre());
        dto.setPosicion(j.getPosicion());
        dto.setDorsal(j.getDorsal());
        dto.setFechaNacimiento(j.getFechaNacimiento());
        dto.setNacionalidad(j.getNacionalidad());
        dto.setEquipoNombre(j.getEquipo() != null ? j.getEquipo().getNombre() : null);
        return dto;
    }

    private Jugador toEntity(JugadorDTO dto) {
        Jugador j = new Jugador();
        j.setNombre(dto.getNombre());
        j.setPosicion(dto.getPosicion());
        j.setDorsal(dto.getDorsal());
        j.setFechaNacimiento(dto.getFechaNacimiento());
        j.setNacionalidad(dto.getNacionalidad());
        return j;
    }

    @Override
    public List<JugadorDTO> getAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JugadorDTO save(JugadorDTO dto) {
        if (dto == null) throw new IllegalStateException("El jugador no puede ser nulo");
        return toDTO(repository.save(toEntity(dto)));
    }

    @Override
    public Optional<JugadorDTO> getById(Long id) {
        Jugador jugador = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Jugador con id " + id + " no existe"));
        return Optional.of(toDTO(jugador));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new IllegalStateException("Jugador con id " + id + " no existe");
        repository.deleteById(id);
    }
}