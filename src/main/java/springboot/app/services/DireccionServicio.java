package springboot.app.services;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.dtos.DireccionDTO;
import springboot.app.model.Direccion;
import springboot.app.repository.DireccionRepository;


import java.util.List;
import java.util.stream.Collectors;

@Service("DireccionServicio")
public class  DireccionServicio implements BaseService<Direccion>{
    @Autowired
    private DireccionRepository direccionRepository;

    @Transactional
    public List<DireccionDTO> getDirecciones()throws Exception{

        var resultado = direccionRepository.findAll();
        try{
            return resultado.stream().map(direccion->new DireccionDTO(direccion.getId(),direccion.getCiudad(),direccion.getCalle())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Direccion> findAll() throws Exception {
       return direccionRepository.findAll();
    }

    @Override
    public Direccion findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Direccion save(Direccion entity) throws Exception {
        return null;
    }

    @Override
    public Direccion update(Long id, Direccion entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }
}
