package in.ineuron.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping("/hello/{user}")
	public ResponseEntity<String> sayHello(@PathVariable("user") String username) {

		String message = "Helloo .....";
		return ResponseEntity.ok().body(message + username);
	}
}
