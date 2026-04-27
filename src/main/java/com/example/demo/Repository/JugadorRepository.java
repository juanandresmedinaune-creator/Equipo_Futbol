package com.example.demo.Repository;

import com.example.demo.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    @Query(value = "SELECT * FROM jugadores WHERE equipo_id = :equipoId", nativeQuery = true)
    List<Jugador> findByEquipoNative(@Param("equipoId") Long equipoId);

    @Query(value = "SELECT j.* FROM jugadores j " +
            "JOIN estadisticas_jugador e ON j.id = e.jugador_id " +
            "WHERE e.goles >= :minGoles", nativeQuery = true)
    List<Jugador> findGoleadores(@Param("minGoles") int minGoles);
}