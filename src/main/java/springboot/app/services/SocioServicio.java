package springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.app.dtos.SocioDto;
import springboot.app.model.Socio;
import springboot.app.repository.SocioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("SocioService")
public class SocioServicio {
    @Autowired
    private SocioRepository socioRepository;


    public List<SocioDto> findAll() throws Exception {
        var resultado = socioRepository.findAll();
        try {
            return resultado.stream().map(socio -> new SocioDto(socio.getPersona().getId(), socio.getTipo())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public SocioDto findById(Long id) throws Exception {
        Optional<Socio> resultado = socioRepository.findById(id);
        try {
            if (resultado.isPresent()){
                SocioDto socioDTO = new SocioDto();
                socioDTO.setId(resultado.get().getId());
                socioDTO.setTipo(resultado.get().getTipo());
                return socioDTO;
            }else {
                return null;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
