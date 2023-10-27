package springboot.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.app.services.SocioServicio;


@RestController
@RequestMapping("/socio")
public class SocioController {
    @Autowired
    private SocioServicio socioServicio;

    @GetMapping("")
    public ResponseEntity<?> getAllSocios(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(socioServicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(socioServicio.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            if (socioServicio.findById(id) != null){
                return ResponseEntity.status(HttpStatus.OK).body(socioServicio.delete(id));
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al eliminar al socio seleccionado");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al eliminar");
        }
    }

}
