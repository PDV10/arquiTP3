package springboot.app.repository;


import org.springframework.stereotype.Repository;
import springboot.app.model.Direccion;

import java.util.List;
import java.util.Optional;

@Repository("DireccionRepository")
public interface DireccionRepository extends RepoBase<Direccion,Integer> {

    public List<Direccion> findAll();

    public Optional<Direccion> findById(Long id);
    public List<Direccion> findAllByCiudad(String ciudad);
}
