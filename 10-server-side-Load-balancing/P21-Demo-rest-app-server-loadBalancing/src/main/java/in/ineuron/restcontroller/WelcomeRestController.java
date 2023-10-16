package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class WelcomeRestController {

	@Autowired
	private Environment environment;

	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMsg() {
		String msg = "Welcome to iNeuron";

		String portInfo = environment.getProperty("local.server.port");

		msg = msg.concat(", Application is running on the port no :: " + portInfo);

		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
