package in.ineuron.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STOCK-PRICE-SERVICE")
public interface IStockServiceClient {

	@GetMapping("/price/stockPrice/{companyName}")
	public ResponseEntity<Double> invokeGetStockPrice(@PathVariable String companyName);
}

