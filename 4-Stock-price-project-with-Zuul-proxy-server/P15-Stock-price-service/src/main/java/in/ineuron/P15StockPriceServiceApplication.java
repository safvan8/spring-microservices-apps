package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class P15StockPriceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(P15StockPriceServiceApplication.class, args);
	}

}
