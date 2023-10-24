package controller;

import model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.PersonaServicio;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaServicio persona ;



}
