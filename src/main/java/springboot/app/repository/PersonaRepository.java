package springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.app.model.Persona;

import java.util.List;
import java.util.Optional;

@Repository("PersonaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    public List<Persona> findAll();

    public Optional<Persona> findById(Long id);

    public boolean existsById(Long id);

    public Persona save(Persona p);

}
