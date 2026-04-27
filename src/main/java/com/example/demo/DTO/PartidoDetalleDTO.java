package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidoDetalleDTO {
    private Long idPartido;
    private String fecha;
    private String estadio;
    private String equipoLocal; // Nombre del equipo
    private String equipoVisita; // Nombre del equipo
    private Integer golesLocal;
    private Integer golesVisita;
}