package africa.semicolon.uncoin.exception;

import africa.semicolon.uncoin.utils.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GenericHandler {

    @ExceptionHandler(RegistrationException.class)
    public ResponseEntity<ApiResponse> GenericHandler(
            RegistrationException registrationException,
            HttpServletRequest httpServletRequest
    ){
        ApiResponse apiResponse = ApiResponse.builder()
                .timeStamp(ZonedDateTime.now())
                .data(registrationException.getMessage())
                .path(httpServletRequest.getRequestURI())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build();
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CONFLICT);
    }
}
