package maids.cc.quiz2.errors.sales;

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
public class SaleExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SaleNotFoundException.class)
    public ResponseEntity<ErrorMessage> saleNotFoundException(SaleNotFoundException exception,
                                                              WebRequest request){
        var message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }
}
