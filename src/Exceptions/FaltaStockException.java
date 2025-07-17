package Exceptions;

public class FaltaStockException extends RuntimeException {
    public FaltaStockException(String message) {
        super(message);
    }
}
