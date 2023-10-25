package springboot.app.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import springboot.app.model.Direccion;
import springboot.app.repository.DireccionRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CargaDeDatos {

    private final DireccionRepository direccionRepository;

    @Autowired
    public CargaDeDatos(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public void cargarDatosDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/springboot/app/csv/domicilios.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Direccion direccion = new Direccion();
                direccion.setCiudad(csvRecord.get("ciudad"));
                direccion.setCalle(csvRecord.get("calle"));
                direccionRepository.save(direccion);
            }
        }


    }

}

