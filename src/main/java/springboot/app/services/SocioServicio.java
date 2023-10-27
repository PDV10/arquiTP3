package springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.dtos.DireccionDTO;
import springboot.app.dtos.PersonaDTO;
import springboot.app.dtos.SocioDto;
import springboot.app.model.Direccion;
import springboot.app.model.Persona;
import springboot.app.model.Socio;
import springboot.app.repository.SocioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("SocioService")
public class SocioServicio {
    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private PersonaServicio personaServicio;
    @Autowired
    private DireccionServicio direccionServicio;

    public List<SocioDto> findAll() throws Exception {
        var resultado = socioRepository.findAll();

        try {

            return resultado.stream().map(socio -> new SocioDto(socio.getPersona().getId(), socio.getTipo(),socio.getPersona())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

//    public SocioDto findById(Long id) throws Exception {
//        Optional<Socio> resultado = socioRepository.findById(id);
//        try {
//            if (resultado.isPresent()){
//                SocioDto socioDTO = new SocioDto();
//                socioDTO.setId(resultado.get().getId());
//                socioDTO.setTipo(resultado.get().getTipo());
//                return socioDTO;
//            }else {
//                return null;
//            }
//        }catch (Exception e){
//            throw new Exception(e.getMessage());
//        }
//    }

    public SocioDto findById(Long id) throws Exception {
        Optional<Socio> resultado = socioRepository.findById(id);
        try {
            if (resultado.isPresent()){
                PersonaDTO personaDTO = personaServicio.findById(id);
                Persona persona = new Persona(personaDTO.getId(),personaDTO.getNombre(),personaDTO.getEdad());
                DireccionDTO direccionDTO = direccionServicio.findById(id);
                Direccion direccion = new Direccion(direccionDTO.getId(),direccionDTO.getCiudad(),direccionDTO.getCalle());
                persona.setDomicilio(direccion);

                SocioDto socioDTO = new SocioDto();
                socioDTO.setId(resultado.get().getId());
                socioDTO.setTipo(resultado.get().getTipo());
                socioDTO.setPersona(persona);
                return socioDTO;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean delete(Long id) throws Exception {

        socioRepository.deleteById(id);
        Optional<Socio> respuesta = socioRepository.findById(id);
        try {
            if(!respuesta.isPresent()){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
