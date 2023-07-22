package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.IStockServiceClient;

@RestController
@RequestMapping("/calc")
public class StockCalculationRestController {

	@Autowired
	private IStockServiceClient stockServiceClient;

	@GetMapping("/calculate/{company}/{stockCount}")
	public ResponseEntity<?> calculateStock(@PathVariable String company, @PathVariable Integer stockCount) {

		System.out.println("StockCalculationRestController.calculateStock()...........");
		
		Double totalPrice = null;
		ResponseEntity<?> responseEntityFromMS;

		try {
			// callin STOCK-SERVICE microservice for getting stock value of company
			responseEntityFromMS = stockServiceClient.invokeGetStockPrice(company);

			// getting the status code
			int statusCode = responseEntityFromMS.getStatusCode().value();

			// calculate the Toatl stock price

			// calculating total price based on the stock count
			if (statusCode == 200) {
				Double companyStockPrice = (Double) responseEntityFromMS.getBody();

				totalPrice = companyStockPrice * stockCount;

				responseEntityFromMS = new ResponseEntity<>(totalPrice, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseEntityFromMS = new ResponseEntity<String>("Company not found :" + company+e.getCause(), HttpStatus.OK);
		}
		return responseEntityFromMS;
	}
}
