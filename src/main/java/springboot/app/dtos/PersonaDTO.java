package springboot.app.dtos;

import springboot.app.model.Direccion;

public class PersonaDTO {
    private Long id ;
    private String nombre;
    private int edad;

    private String calle;
    private String ciudad;

    private Direccion direccion;
    public PersonaDTO(Long id, String nombre, int edad, String calle, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.calle = calle;
        this.ciudad = ciudad;
    }

    public PersonaDTO() {

    }

    public PersonaDTO(Long id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
