package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

//@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableCircuitBreaker
public class SbCloudHystricCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbCloudHystricCircuitBreakerApplication.class, args);
	}

}
