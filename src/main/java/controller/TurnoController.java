package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.TurnoServicio;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    private TurnoServicio turno;


}
