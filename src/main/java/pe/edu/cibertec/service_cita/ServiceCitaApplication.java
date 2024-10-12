package pe.edu.cibertec.service_cita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceCitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCitaApplication.class, args);
	}

}
