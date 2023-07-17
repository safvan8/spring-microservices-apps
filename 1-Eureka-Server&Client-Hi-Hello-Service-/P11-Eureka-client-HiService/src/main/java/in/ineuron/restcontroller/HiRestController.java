package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiRestController {

	@GetMapping("/hi/{name}")
	public String sayHi(@PathVariable String name) {
		return "Hi " + name + ", How are you !";
	}
}
