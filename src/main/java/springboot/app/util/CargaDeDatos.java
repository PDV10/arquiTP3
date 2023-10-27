package springboot.app.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import springboot.app.model.Direccion;
import springboot.app.model.Persona;
import springboot.app.model.Socio;
import springboot.app.repository.DireccionRepository;
import springboot.app.repository.PersonaRepository;
import springboot.app.repository.SocioRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CargaDeDatos {

    private final DireccionRepository direccionRepository;
    private final PersonaRepository personaRepository;
    private final SocioRepository socioRepository;

    @Autowired
    public CargaDeDatos(DireccionRepository direccionRepository, PersonaRepository personaRepository, SocioRepository socioRepository) {
        this.direccionRepository = direccionRepository;
        this.personaRepository = personaRepository;
        this.socioRepository = socioRepository;
    }

    public void cargarDatosDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/springboot/app/csv/domicilios.csv");
        List<Direccion> direcciones = new ArrayList<Direccion>();
        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Direccion direccion = new Direccion();
                direccion.setCiudad(csvRecord.get("ciudad"));
                direccion.setCalle(csvRecord.get("calle"));
                direcciones.add(direccion);
                direccionRepository.save(direccion);

            }
        }

        archivoCSV = ResourceUtils.getFile("src/main/java/springboot/app/csv/personas.csv");
        List<Persona> personas = new ArrayList<>();
        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                Persona persona = new Persona();
                persona.setId(Long.valueOf(csvRecord.get("id")));
                persona.setNombre(csvRecord.get("nombre"));
                persona.setEdad(Integer.parseInt(csvRecord.get("edad")));
                personas.add(persona);
                //asignando un domicilio random
                int indiceAleatorio = new Random().nextInt(direcciones.size()-1);
                Direccion direccionAleatoria = direcciones.get(indiceAleatorio);
                persona.setDomicilio(direccionAleatoria);

                personaRepository.save(persona);
            }
        }

        archivoCSV = ResourceUtils.getFile("src/main/java/springboot/app/csv/socio.csv");
        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                Socio socio = new Socio();

                //asignando un id a socios
                int indiceAleatorio = new Random().nextInt(personas.size()-1);
                Persona p = personas.get(indiceAleatorio);
                socio.setId(p.getId());
                socio.setTipo(csvRecord.get("tipo"));
                socio.setPersona(p);

                socioRepository.save(socio);
            }
        }
    }

}

