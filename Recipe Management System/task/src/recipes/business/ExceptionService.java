package recipes.business;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Void> handleRecipeNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Void> handleConstraintViolation() {
        return ResponseEntity.badRequest().build();
    }
}
