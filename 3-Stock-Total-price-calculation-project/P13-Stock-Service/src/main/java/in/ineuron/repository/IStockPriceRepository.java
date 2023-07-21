package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.entity.StockPrice;

public interface IStockPriceRepository extends JpaRepository<StockPrice, Integer> {

	public StockPrice findByCompanyNameIgnoreCase(String companyName);
}
