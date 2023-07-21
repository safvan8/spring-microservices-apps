package in.ineuron.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STOCK-SERVICE")
public interface IStockServiceClient {

	@GetMapping("/api/price/stockprice/{companyName}")
	public ResponseEntity<Double> invokeGetStockPrice(@PathVariable String companyName);
}

