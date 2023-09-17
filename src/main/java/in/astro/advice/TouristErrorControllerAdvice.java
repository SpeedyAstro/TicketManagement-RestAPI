package in.astro.advice;

import in.astro.error.CustomError;
import in.astro.exception.TouristNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TouristErrorControllerAdvice {
    @ExceptionHandler(TouristNotFound.class)
    public ResponseEntity<CustomError> handleTouristNotFound(TouristNotFound exception){
        CustomError customError = new CustomError(LocalDateTime.now(), exception.getMessage(), "404-Not Found!!");
        return new ResponseEntity<CustomError>(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleAllProblems(Exception e){
        System.out.println("TouristErrorControllerAdvice.handleAllProblems");
        CustomError error = new CustomError(LocalDateTime.now(), e.getMessage(), "Problem In Execution");
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
