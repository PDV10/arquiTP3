package springboot.app.services;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.dtos.DireccionDTO;
import springboot.app.model.Direccion;
import springboot.app.repository.DireccionRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("DireccionServicio")
public class  DireccionServicio {
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

    public List<Direccion> findAll() throws Exception {
       return direccionRepository.findAll();
    }

    @Transactional
    public List<DireccionDTO> findAllByCiudad(String ciudad) throws Exception {
        var resultado = direccionRepository.findAllByCiudad(ciudad);
        try {
            return resultado.stream().map(direccion -> new DireccionDTO(direccion.getId(), direccion.getCiudad(), direccion.getCalle())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Transactional
    public DireccionDTO findById(Long id) throws Exception {
        try {
            Optional<Direccion> direccion = direccionRepository.findById(id);
            if (direccion.isPresent()){
                return new DireccionDTO(direccion.get().getId(),direccion.get().getCiudad(),direccion.get().getCalle());
            }else {
                return null;
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Direccion findByCalle(String calle) throws Exception {
        try {
            Optional<Direccion> direccion = direccionRepository.findByCalle(calle);
            return direccion.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public DireccionDTO post(DireccionDTO entity) throws Exception {
        System.out.println("Entra al post del Servicio");
        Direccion direccion = new Direccion(entity.getCiudad(),entity.getCalle());
        Direccion response = direccionRepository.save(direccion);
        return new DireccionDTO(response.getCiudad(), response.getCalle());
    }

    @Transactional
    public Direccion update(Long id, Direccion nuevaDireccion) throws Exception {
        Optional<Direccion> direccionExistente = direccionRepository.findById(id);
        try {
            if (direccionExistente.isPresent()) {
                Direccion direccionActual = direccionExistente.get();

                direccionActual.setCiudad(nuevaDireccion.getCiudad());
                direccionActual.setCalle(nuevaDireccion.getCalle());

                return direccionRepository.save(direccionActual);

            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public void delete(Long id) throws Exception {
       direccionRepository.deleteById(id);
    }

    @Transactional
    public boolean findDireccion(DireccionDTO d) throws Exception{
        try {
            String calle = d.getCalle();
            String ciudad = d.getCiudad();

            return direccionRepository.existsByCalleAndCiudad(calle,ciudad);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
