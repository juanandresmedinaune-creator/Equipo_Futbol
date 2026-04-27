package com.example.demo.Controller;

import com.example.demo.DTO.PartidoDTO;
import com.example.demo.DTO.PartidoDetalleDTO;
import com.example.demo.Service.PartidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    private final PartidoService service;

    public PartidoController(PartidoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PartidoDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/resultados")
    public List<PartidoDetalleDTO> getResultados() {
        return service.obtenerResultadosConNombres();
    }

    @PostMapping
    public ResponseEntity<PartidoDTO> save(@RequestBody PartidoDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}