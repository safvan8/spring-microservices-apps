package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.HelloServiceClient;

@RestController
public class HiRestController {

	@Autowired
	private HelloServiceClient helloServiceClient;

	@GetMapping("/hi/{name}")
	public String consumeHelloService(@PathVariable String name) {

		System.out.println("**********************************");

		System.out.println("Calling HELLO-SERVICE method :");

		String wishMessage = helloServiceClient.invokeSayHello("Java Developer");

		System.out.println(wishMessage);

		System.out.println("**********************************");

		return wishMessage + "=======" +name;
	}
}
