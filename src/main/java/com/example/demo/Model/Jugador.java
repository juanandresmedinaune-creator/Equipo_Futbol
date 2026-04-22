package com.example.demo.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String posicion;
    private Integer dorsal;
    private LocalDate fechaNacimiento;
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
    private List<EstadisticasJugador> estadisticas;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }
    public Integer getDorsal() { return dorsal; }
    public void setDorsal(Integer dorsal) { this.dorsal = dorsal; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }
    public List<EstadisticasJugador> getEstadisticas() { return estadisticas; }
    public void setEstadisticas(List<EstadisticasJugador> estadisticas) { this.estadisticas = estadisticas; }
}