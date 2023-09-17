package in.astro.exception;

public class TouristNotFound extends RuntimeException{
    public TouristNotFound(String message) {
        super(message);
    }
}
