package springboot.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.app.model.Direccion;

import java.util.List;
import java.util.Optional;

@Repository("DireccionRepository")
public interface DireccionRepository extends JpaRepository<Direccion,Long> {

    public List<Direccion> findAll();

    public Optional<Direccion> findById(Long id);
    public List<Direccion> findAllByCiudad(String ciudad);

    public void deleteById(Long id);

}
