package INVESTHOR365.UserDemo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestExceptionalHandler {

    @ExceptionHandler(Exception.class)
        public ResponseEntity<String> exceptionHandler(Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error Occurred");
        }
    }