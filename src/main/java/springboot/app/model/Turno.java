package springboot.app.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Timestamp fecha;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Persona> jugadores;

    public Turno() {
    }

    public Turno(Timestamp fecha, List<Persona> jugadores) {
        this.fecha = fecha;
        this.jugadores = jugadores;
    }

    public Turno(Long id, Timestamp fecha) {
        this.id = id;
        this.fecha = fecha;
        this.jugadores = new ArrayList<Persona>();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public List<Persona> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Persona> jugadores) {
        this.jugadores = jugadores;
    }

    public Turno(Timestamp fecha) {
        this.fecha = fecha;
        this.jugadores = new ArrayList<Persona>();
    }

    @Override
    public String toString() {
        return "\nTurno{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", jugadores=" + jugadores +
                '}';
    }
}
