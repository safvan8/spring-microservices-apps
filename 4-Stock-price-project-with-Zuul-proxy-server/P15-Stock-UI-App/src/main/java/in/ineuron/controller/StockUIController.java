package in.ineuron.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.service.IStockUIService;

@Controller
public class StockUIController {

	@Autowired
	private IStockUIService stockUIService;

	@GetMapping("/")
	public String showHome() {
		return "index";
	}

	@GetMapping("/getTotalCost")
	public String getTotalCost(@RequestParam String companyName, @RequestParam Integer stockCount,
			Map<String, Object> model) {
		System.out.println("StockUIController.getTotalCost()---------" + stockCount);

		String messageWithStockPrice = stockUIService.getTotalStockPrice(companyName, stockCount);

		model.put("messageWithStockPrice", messageWithStockPrice);

		return "index";
	}
}
