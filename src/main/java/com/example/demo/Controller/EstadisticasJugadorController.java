package com.example.demo.Controller;

import com.example.demo.DTO.EstadisticasJugadorDTO;
import com.example.demo.Service.EstadisticasJugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasJugadorController {

    private final EstadisticasJugadorService service;

    public EstadisticasJugadorController(EstadisticasJugadorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EstadisticasJugadorDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticasJugadorDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadisticasJugadorDTO> save(@RequestBody EstadisticasJugadorDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}