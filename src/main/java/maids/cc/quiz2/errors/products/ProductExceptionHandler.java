package maids.cc.quiz2.errors.products;

import maids.cc.quiz2.errors.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FailedToSaveProductException.class)
    public ResponseEntity<ErrorMessage> failedToSaveProductException(FailedToSaveProductException exception,
                                                                     WebRequest request){
        var message = new ErrorMessage(HttpStatus.BAD_REQUEST,exception.getMessage());
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> productNotFoundException(ProductNotFoundException exception,
                                                                     WebRequest request){
        var message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }

}
