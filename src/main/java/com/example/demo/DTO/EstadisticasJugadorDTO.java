package com.example.demo.DTO;

public class EstadisticasJugadorDTO {
    private Integer partidosJugados;
    private Integer goles;
    private Integer asistencias;
    private Integer tarjetasAmarillas;
    private Integer tarjetasRojas;
    private String jugadorNombre;

    public Integer getPartidosJugados() { return partidosJugados; }
    public void setPartidosJugados(Integer partidosJugados) { this.partidosJugados = partidosJugados; }
    public Integer getGoles() { return goles; }
    public void setGoles(Integer goles) { this.goles = goles; }
    public Integer getAsistencias() { return asistencias; }
    public void setAsistencias(Integer asistencias) { this.asistencias = asistencias; }
    public Integer getTarjetasAmarillas() { return tarjetasAmarillas; }
    public void setTarjetasAmarillas(Integer tarjetasAmarillas) { this.tarjetasAmarillas = tarjetasAmarillas; }
    public Integer getTarjetasRojas() { return tarjetasRojas; }
    public void setTarjetasRojas(Integer tarjetasRojas) { this.tarjetasRojas = tarjetasRojas; }
    public String getJugadorNombre() { return jugadorNombre; }
    public void setJugadorNombre(String jugadorNombre) { this.jugadorNombre = jugadorNombre; }
}