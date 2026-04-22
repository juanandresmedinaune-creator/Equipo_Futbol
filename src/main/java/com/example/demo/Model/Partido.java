package com.example.demo.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partidos")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String rival;
    private Integer golesFavor;
    private Integer golesContra;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getRival() { return rival; }
    public void setRival(String rival) { this.rival = rival; }
    public Integer getGolesFavor() { return golesFavor; }
    public void setGolesFavor(Integer golesFavor) { this.golesFavor = golesFavor; }
    public Integer getGolesContra() { return golesContra; }
    public void setGolesContra(Integer golesContra) { this.golesContra = golesContra; }
    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }
}