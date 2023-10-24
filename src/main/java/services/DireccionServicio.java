package services;

import dtos.DireccionDTO;
import jakarta.transaction.Transactional;
import model.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DireccionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service("DireccionServicio")
public class DireccionServicio {
    @Autowired
    private DireccionRepository<Direccion,Integer> direccionRepository;

    @Transactional
    public List<DireccionDTO> getDirecciones()throws Exception{

        var resultado = direccionRepository.findAll();
        try{
            return resultado.stream().map(direccion->new DireccionDTO(direccion.getId(),direccion.getCiudad(),direccion.getCalle())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
