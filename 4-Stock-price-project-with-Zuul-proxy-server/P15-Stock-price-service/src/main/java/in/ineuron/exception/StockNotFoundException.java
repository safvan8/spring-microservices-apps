package in.ineuron.exception;

import lombok.Data;

@Data
public class StockNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockNotFoundException(String messsage) {
		super(messsage);
	}
}
