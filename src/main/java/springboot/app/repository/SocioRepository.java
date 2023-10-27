package springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.app.model.Socio;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocioRepository extends JpaRepository<Socio,Long> {
    public List<Socio> findAll();
    public Optional<Socio> findById(Long id);
    public void deleteById(Long id);
}
