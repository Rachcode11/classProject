package africa.semicolon.uncoin.registration;

import africa.semicolon.uncoin.exception.RegistrationException;
import africa.semicolon.uncoin.registration.dtos.RegistrationRequest;
import africa.semicolon.uncoin.utils.ApiResponse;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {
     @Autowired
     RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegistrationRequest registrationRequest, HttpServletRequest httpServletRequest)
            throws MessagingException, RegistrationException {

        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .data(registrationService.register(registrationRequest))
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
         return new  ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);


    }
}
