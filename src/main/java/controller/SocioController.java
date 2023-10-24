package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.SocioServicio;

@RestController
@RequestMapping("/socio")
public class SocioController {
    @Autowired
    private SocioServicio socio;

}
