package springboot.app.repository;


import org.springframework.stereotype.Repository;
import springboot.app.model.Direccion;

import java.util.List;

@Repository("DireccionRepository")
public interface DireccionRepository extends RepoBase<Direccion,Integer> {

    public List<Direccion> findAll();
}
