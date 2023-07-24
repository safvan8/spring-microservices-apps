package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class P17AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(P17AdminServerApplication.class, args);
	}

}
