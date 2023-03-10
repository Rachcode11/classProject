package africa.semicolon.uncoin.registration.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConfirmTokenRequest {

    @NotNull
    private String token;

    @NotNull
    private String email;
}
