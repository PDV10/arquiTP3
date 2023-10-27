package springboot.app.services;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import springboot.app.dtos.PersonaDTO;
import springboot.app.model.Direccion;
import springboot.app.model.Persona;
import springboot.app.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("PersonaServicio")
public class PersonaServicio {
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    DireccionServicio direccionServicio;


    @Transactional
    public Persona findByNombre(String nombre) {
        return null;
    }

    @Transactional
    public List<PersonaDTO> findAll() throws Exception {
        var resultado = personaRepository.findAll();

        try {
            return resultado.stream().map(persona -> new PersonaDTO(persona.getId(), persona.getNombre(), persona.getEdad(), persona.getDomicilio().getCalle(), persona.getDomicilio().getCiudad())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Transactional
    public PersonaDTO findById(Long id) throws Exception {
        Optional<Persona> resultado = personaRepository.findById(id);
        try {
            if (resultado.isPresent()) {
                Persona persona = resultado.get();
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setId(persona.getId());
                personaDTO.setNombre(persona.getNombre());
                personaDTO.setEdad(persona.getEdad());
                personaDTO.setCalle(persona.getDomicilio().getCalle());
                personaDTO.setCiudad(persona.getDomicilio().getCiudad());
                return personaDTO;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public PersonaDTO save(PersonaDTO personaDTO) throws Exception {
        //Persona persona = new Persona(personaDTO.getId(), personaDTO.getNombre(), personaDTO.getEdad(), new Direccion(personaDTO.getCiudad(), personaDTO.getCalle()));

        Persona persona = new Persona(personaDTO.getId(), personaDTO.getNombre(), personaDTO.getEdad());

        Persona p = personaRepository.save(persona);
        PersonaDTO resultado = new PersonaDTO(p.getId(), p.getNombre(), p.getEdad());
        return resultado;
    }


    @Transactional
    public PersonaDTO update(Long id, PersonaDTO personaDTO) throws Exception {
        Optional<Persona> p = personaRepository.findById(id);

        try {
            if (p.isPresent()) {
                Persona personaModificada = p.get();
                Direccion direccion = new Direccion();
                direccion.setCalle(personaDTO.getCalle());
                direccion.setCiudad(personaDTO.getCiudad());

                personaModificada.setId(personaDTO.getId());
                personaModificada.setEdad(personaDTO.getEdad());
                personaModificada.setNombre(personaDTO.getNombre());

                Persona per = personaRepository.save(personaModificada);

                return new PersonaDTO(per.getId(), per.getNombre(), per.getEdad(), per.getDomicilio().getCalle(), per.getDomicilio().getCiudad());

            } else {
                return null;
            }
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }

    }


    @Transactional
    public boolean delete(Long id) throws Exception {
        return false;
    }

    @Transactional
    public boolean existyById(Long id){
        return personaRepository.existsById(id);
    }

}
