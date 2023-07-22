package in.ineuron.restcontroller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class SampleRestController {

	@GetMapping("wish/{userName}")
	public ResponseEntity<String> generateWishMessage(@PathVariable String userName) {
		LocalDateTime localDateTime = LocalDateTime.now();
		int hour = localDateTime.getHour();

		String body = null;

		if (hour < 12)
			body = "Good Morning";
		else if (hour < 20)
			body = "Good Evening";
		else
			body = "Good Night";

		return ResponseEntity.ok().body(body);
	}
}
