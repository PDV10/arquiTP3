package springboot.app.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/*
 *Vamos a decirle que esta clase es una tabla con la palabara @entity*/
@Entity
public class Persona {
    //esta persona va a tener un id
    @Id
    private int id;
    //Marcamos las columnas de la BD
    /*
     *Le indicamos que no puede ser nulleable */
    @Column(nullable = false)
    private String nombre;
    /*
     * Podemos decirle que esta columna en la BD se llama años con Column(name = "nuevo nombre")
     */
    @Column(name = "anios")
    private int edad;

    /*
     *Indicamos en la relacion que muchas personas puedan vivir en un mismo domicilio pero no puede vivir en dos lugares distitnos
     */
    @ManyToOne
    private Direccion domicilio;

    @ManyToMany(mappedBy = "jugadores", fetch = FetchType.LAZY)
    private List<Turno> turnos;
    public static final String BUSCAR_TODAS = "Persona.buscarTodas";
    public static final String BUSCAR_POR_ID = "Persona.buscarPorId";

    public Persona(int id, String nombre, int edad, Direccion domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.domicilio = domicilio;
    }

    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    public Persona() {
        this.turnos = new ArrayList<Turno>();
    }

    @Override
    public String toString() {
        return "\nPersona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", domicilio=" + domicilio +
                '}';
    }
}
