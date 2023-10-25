package springboot.app;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.app.util.CargaDeDatos;

import java.io.IOException;

@SpringBootApplication
public class ArquiTp3Application {

	@Autowired
	private CargaDeDatos cargaDeDatos;
	public static void main(String[] args) {
		SpringApplication.run(ArquiTp3Application.class, args);
	}

	@PostConstruct
	public void init() throws IOException {
		cargaDeDatos.cargarDatosDesdeCSV();
	}

}