package in.ineuron.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StockServiceImpl implements IStockUIService {

	private static final String REST_END_POINT = "http://localhost:1111/api/stock/calc/calculation/{company}/{stockCount}";

	String response = null;

	@Override
	public String getTotalStockPrice(String companyName, Integer stockCount) {

		WebClient webClient = WebClient.create();
		try {
			  response = webClient
						.get()
						.uri(REST_END_POINT, companyName, stockCount)
						.retrieve()
						.bodyToMono(String.class)
						.block();
			  System.out.println("StockServiceImpl.getTotalStockPrice()=====================");
			  System.out.println(response);
			  
		} catch (Exception e) {
			response = "Company not found :" + companyName;
		}
		return response;
	}

}
