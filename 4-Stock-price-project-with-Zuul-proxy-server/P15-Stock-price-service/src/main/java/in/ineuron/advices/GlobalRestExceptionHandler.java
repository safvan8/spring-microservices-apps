package in.ineuron.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.exception.StockNotFoundException;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<String> handleStockNotFoundException(StockNotFoundException se) {
		return new ResponseEntity<String>(se.getMessage(), HttpStatus.NOT_FOUND);
	}
}
