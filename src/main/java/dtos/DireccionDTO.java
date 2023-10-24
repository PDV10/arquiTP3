package dtos;

public class DireccionDTO {
    private int id ;
    private String ciudad;
    private String calle;

    public DireccionDTO() {
    }

    public DireccionDTO(int id, String ciudad, String calle) {
        this.id = id;
        this.ciudad = ciudad;
        this.calle = calle;
    }

    public DireccionDTO(String ciudad, String calle) {
        this.ciudad = ciudad;
        this.calle = calle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return " DireccionDTO{" +
                " id=" + id +
                " ciudad='" + ciudad + '\'' +
                " calle='" + calle + " }\n" ;
    }
}
