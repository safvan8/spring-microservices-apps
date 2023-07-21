package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.entity.StockPrice;
import in.ineuron.exception.StockNotFoundException;
import in.ineuron.repository.IStockPriceRepository;

@Service
public class IStockPriceImpl implements IStockPriceService {

	@Autowired
	private IStockPriceRepository stockPriceRepository;

	@Override
	public Double getStockPriceByCompanyName(String companyName) {
		StockPrice stockPrice = stockPriceRepository.findByCompanyNameIgnoreCase(companyName);

		if (stockPrice == null)
			throw new StockNotFoundException("Stock Not available form Company: " + companyName);

		return stockPrice.getCompanyPrice();
	}
}
