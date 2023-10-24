package repository;

import dtos.DireccionDTO;
import model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DireccionRepository")
public interface DireccionRepository<Direccion,Integer> {

    public List<Direccion> findAll();
}
