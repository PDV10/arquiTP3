package springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.app.model.Persona;
import springboot.app.services.PersonaServicio;


@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaServicio personaServicio ;

    @GetMapping("")
    public ResponseEntity<?> getPersonas(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaServicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error no se encontraron personas");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonaById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaServicio.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, persona no encontrada");
        }
    }

    @PostMapping("{id}")
    public ResponseEntity addPersona(@PathVariable Long id, @RequestBody Persona persona){
      return null;
    }


}
