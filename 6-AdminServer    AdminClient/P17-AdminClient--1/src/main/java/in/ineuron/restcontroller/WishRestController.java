package in.ineuron.restcontroller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishRestController {

	@GetMapping("/wish/{user}")
	public ResponseEntity<String> sayHello(@PathVariable("user") String username) {

		LocalDateTime localDateTime = LocalDateTime.now();

		int hour = localDateTime.getHour();

		String message = null;

		if (hour < 14)
			message = "Good Morning! ";
		else if (hour < 18)
			message = "Good After Noon!";
		else
			message = " Good Night! ";
		return ResponseEntity.ok().body(message + username);
	}
}
