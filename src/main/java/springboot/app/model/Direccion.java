package springboot.app.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Direccion {
    @Id
    //Indicamos que el id sea AUTO-INCREMENT
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String ciudad;
    @Column
    private String calle;
    /*
     *Una direccion puede ir con multiples personas.
     *Todas las relaciones q se mapean a listo tienen un Fetchtype.lazy
     * Hasta que no pidamso algo relacionado con esta list, no se va a hacer el FECTH pq es muy costosos */
    //@OneToMany(mappedBy = "domicilio", fetch = FetchType.LAZY)
   // private List<Persona> habitantes;
    public static final String OBTENER_PERSONAS_DE_UNA_CIUDAD = "Direccion.OBTENER_PERSONAS_DE_UNA_CIUDAD";


    public Direccion(String ciudad, String calle) {
        this.ciudad = ciudad;
        this.calle = calle;
    }

    public Direccion() {

    }

    public Long getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return "\nDireccion{" +
                "id=" + id +
                ", ciudad='" + ciudad + '\'' +
                ", calle='" + calle + '\'' +
                '}';
    }
}
