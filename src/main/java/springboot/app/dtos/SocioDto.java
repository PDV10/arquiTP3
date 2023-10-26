package springboot.app.dtos;

import springboot.app.model.Persona;

public class SocioDto {
    private Long id;
    private String tipo;
    private Persona persona;

    public SocioDto() {
    }

    public SocioDto(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public SocioDto(Long id, String tipo, Persona persona) {
        this.id = id;
        this.tipo = tipo;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
