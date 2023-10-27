package springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.app.dtos.DireccionDTO;
import springboot.app.model.Direccion;
import springboot.app.services.DireccionServicio;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/direccion")
public class DireccionController {
    @Autowired
    private DireccionServicio direccionServicio;

    public DireccionController() {
    }

    @GetMapping("")
    public ResponseEntity<?> getDirecciones() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(direccionServicio.getDirecciones());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(direccionServicio.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/ciudad/{ciudad}")
    public ResponseEntity<?>findAllByCiudad(@PathVariable String ciudad){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(direccionServicio.findAllByCiudad(ciudad));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Direccion direccion){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(direccionServicio.update(id,direccion));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            if(direccionServicio.findById(id) != null){
                direccionServicio.delete(id);
               // ResponseEntity<?> status = this.findById(id);
                //if (status.getStatusCode().equals(HttpStatus.NOT_FOUND)){
                    return ResponseEntity.status(HttpStatus.OK).body("{\"Eliminado con Exito.\"}");
                //}

            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Direccion no existente.\"}");
            }


        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }

    }

    @PostMapping("")
    public ResponseEntity<?> post(@RequestBody DireccionDTO entity){
        try{


            if(!direccionServicio.findDireccion(entity)){
                return ResponseEntity.status(HttpStatus.OK).body(direccionServicio.post(entity));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. La Direccion ya existe.\"}");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}" + e.getMessage() + entity);
        }
    }





}
