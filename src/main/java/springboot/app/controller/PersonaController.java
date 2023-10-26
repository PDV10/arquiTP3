package springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.app.dtos.PersonaDTO;
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
            if(personaServicio.existyById(id)){
                return ResponseEntity.status(HttpStatus.OK).body(personaServicio.findById(id));
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, persona no encontrada");
            }

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, al buscar una persona por id");
        }
    }

    @PostMapping("")
    public ResponseEntity addPersona(@RequestBody PersonaDTO personaDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaServicio.save(personaDTO));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error, no se pudo agregar a la persona ");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePersona(@PathVariable Long id, @RequestBody PersonaDTO personaDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(personaServicio.update(id, personaDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al modificar persona");
        }
    }

}
