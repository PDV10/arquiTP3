package controller;

import model.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.DireccionServicio;

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
}
