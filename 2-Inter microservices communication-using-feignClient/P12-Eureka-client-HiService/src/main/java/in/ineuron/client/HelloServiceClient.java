package in.ineuron.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// client to call another internal microservice

@FeignClient(name = "HELLO-SERVICE")
public interface HelloServiceClient {

	@GetMapping("/hello/{name}")
	public String invokeSayHello(@PathVariable String name);
}
