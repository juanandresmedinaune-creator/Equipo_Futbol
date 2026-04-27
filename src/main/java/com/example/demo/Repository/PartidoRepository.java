package com.example.demo.Repository;

import com.example.demo.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

    @Query(value = "SELECT p.id_partido, p.fecha, p.estadio, e1.nombre AS equipo_local, " +
            "e2.nombre AS equipo_visita, p.goles_local, p.goles_visita " +
            "FROM partidos p " +
            "JOIN equipos e1 ON p.equipo_local_id = e1.id_equipo " +
            "JOIN equipos e2 ON p.equipo_visita_id = e2.id_equipo", nativeQuery = true)
    List<Object[]> findPartidosConNombresNative();
}