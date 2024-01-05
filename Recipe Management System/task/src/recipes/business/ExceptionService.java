package recipes.business;

import org.springframework.http.HttpStatus;
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

    @ExceptionHandler({ConstraintViolationException.class, IllegalStateException.class})
    public ResponseEntity<Void> handleBadRequests() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(UnauthorizedOperationException.class)
    public ResponseEntity<Void> handleUnauthorizedOperations() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
