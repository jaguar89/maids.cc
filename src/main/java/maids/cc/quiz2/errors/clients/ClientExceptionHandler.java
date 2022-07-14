package maids.cc.quiz2.errors.clients;


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
public class ClientExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FailedToSaveClientException.class)
    public ResponseEntity<ErrorMessage> failedToSaveClientException(FailedToSaveClientException exception,
                                                                   WebRequest request) {
        var message = new ErrorMessage(HttpStatus.BAD_REQUEST , exception.getMessage());
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorMessage> clientNotFoundException(ClientNotFoundException exception,
                                                                    WebRequest request) {
        var message = new ErrorMessage(HttpStatus.NOT_FOUND , exception.getMessage());
        return ResponseEntity.status(message.getHttpStatus()).body(message);
    }
}
