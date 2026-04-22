package com.example.demo.DTO;

import java.time.LocalDate;

public class PartidoDTO {
    private LocalDate fecha;
    private String rival;
    private Integer golesFavor;
    private Integer golesContra;
    private String equipoNombre;

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getRival() { return rival; }
    public void setRival(String rival) { this.rival = rival; }
    public Integer getGolesFavor() { return golesFavor; }
    public void setGolesFavor(Integer golesFavor) { this.golesFavor = golesFavor; }
    public Integer getGolesContra() { return golesContra; }
    public void setGolesContra(Integer golesContra) { this.golesContra = golesContra; }
    public String getEquipoNombre() { return equipoNombre; }
    public void setEquipoNombre(String equipoNombre) { this.equipoNombre = equipoNombre; }
}