package springboot.app.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import springboot.app.model.Direccion;
import springboot.app.model.Persona;
import springboot.app.repository.DireccionRepository;
import springboot.app.repository.PersonaRepository;

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

    @Autowired
    public CargaDeDatos(DireccionRepository direccionRepository,PersonaRepository personaRepository) {
        this.direccionRepository = direccionRepository;
        this.personaRepository = personaRepository;
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
        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                Persona persona = new Persona();
                persona.setId(Long.valueOf(csvRecord.get("id")));
                persona.setNombre(csvRecord.get("nombre"));
                persona.setEdad(Integer.parseInt(csvRecord.get("edad")));

                //asignando un domicilio random
                int indiceAleatorio = new Random().nextInt(direcciones.size()-1);
                Direccion direccionAleatoria = direcciones.get(indiceAleatorio);
                persona.setDomicilio(direccionAleatoria);

                personaRepository.save(persona);
            }
        }
    }

}

