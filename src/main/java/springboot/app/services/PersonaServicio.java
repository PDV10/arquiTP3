package springboot.app.services;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import springboot.app.model.Direccion;
import springboot.app.model.Persona;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class PersonaServicio{


    public Persona findByNombre(String nombre) {
        return null;
    }

    public List<Persona> findAll() throws Exception {
        return null;
    }

    public Persona findById(Long id) throws Exception {
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
