package ia.eu.code.Exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice

public class ExceptionHandlerController extends Throwable {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        List<String> d = new ArrayList<>();
        d.add(ex.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND.toString(),d);
        return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
    }
}
