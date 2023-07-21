package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.service.IStockPriceService;

@RestController
@RequestMapping("/api/price")
public class StockPriceRestController {

	@Autowired
	private IStockPriceService stockPriceService;

	@GetMapping("/stockprice/{companyName}")
	public ResponseEntity<Double> getStockPriceByCompanyName(@PathVariable String companyName) {

		Double companyStockPrice = stockPriceService.getStockPriceByCompanyName(companyName);
		
		return ResponseEntity.ok().body(companyStockPrice);
	}
}
