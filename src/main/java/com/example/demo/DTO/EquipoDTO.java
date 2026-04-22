package com.example.demo.DTO;

public class EquipoDTO {
    private String nombre;
    private String ciudad;
    private Integer anioFundacion;
    private String entrenadorNombre;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public Integer getAnioFundacion() { return anioFundacion; }
    public void setAnioFundacion(Integer anioFundacion) { this.anioFundacion = anioFundacion; }
    public String getEntrenadorNombre() { return entrenadorNombre; }
    public void setEntrenadorNombre(String entrenadorNombre) { this.entrenadorNombre = entrenadorNombre; }
}