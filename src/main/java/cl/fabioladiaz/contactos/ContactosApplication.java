package cl.fabioladiaz.contactos;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactosApplication {



	public static void main(String[] args) {

		// Cargar el archivo .env
		Dotenv dotenv = Dotenv.load();
		System.out.println("DB URL: " + dotenv.get("DB_URL"));

		// Pasar a Spring Boot usando System Properties
		System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
		System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
		System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
		SpringApplication.run(ContactosApplication.class, args);
	}

}
