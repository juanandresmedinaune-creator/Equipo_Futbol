package com.example.demo.DTO;

import java.time.LocalDate;

public class JugadorDTO {
    private String nombre;
    private String posicion;
    private Integer dorsal;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String equipoNombre;

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
    public String getEquipoNombre() { return equipoNombre; }
    public void setEquipoNombre(String equipoNombre) { this.equipoNombre = equipoNombre; }
}