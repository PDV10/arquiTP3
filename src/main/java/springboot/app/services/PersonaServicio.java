package springboot.app.services;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import springboot.app.dtos.PersonaDTO;
import springboot.app.model.Direccion;
import springboot.app.model.Persona;
import springboot.app.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("PersonaServicio")
public class PersonaServicio{
    @Autowired
    PersonaRepository personaRepository;

    public Persona findByNombre(String nombre) {
        return null;
    }

    @Transactional
    public List<PersonaDTO> findAll() throws Exception {
        var resultado = personaRepository.findAll();

        try {
            return resultado.stream().map(persona -> new PersonaDTO(persona.getId(),persona.getNombre(),persona.getEdad(),persona.getDomicilio().getCalle(),persona.getDomicilio().getCiudad())).collect(Collectors.toList());
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }

    }

    public PersonaDTO findById(Long id) throws Exception {
        Optional<Persona> resultado = personaRepository.findById(id);
        try {
            if(resultado.isPresent()) {
                Persona persona = resultado.get();
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setId(persona.getId());
                personaDTO.setNombre(persona.getNombre());
                personaDTO.setEdad(persona.getEdad());
                personaDTO.setDireccion(persona.getDomicilio().getCalle());
                personaDTO.setCiudad(persona.getDomicilio().getCiudad());
                return personaDTO;
            }


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return null;

    }

    public Persona save(Persona entity) throws Exception {
        return null;
    }

    public Persona update(Long id, Persona entity) throws Exception {
        return null;
    }


    public boolean delete(Long id) throws Exception {
        return false;
    }
}
