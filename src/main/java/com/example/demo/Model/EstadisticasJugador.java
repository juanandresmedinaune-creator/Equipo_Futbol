package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "estadisticas_jugador")
public class EstadisticasJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer partidosJugados;
    private Integer goles;
    private Integer asistencias;
    private Integer tarjetasAmarillas;
    private Integer tarjetasRojas;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
    public Jugador getJugador() { return jugador; }
    public void setJugador(Jugador jugador) { this.jugador = jugador; }
}