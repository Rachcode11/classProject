package africa.semicolon.uncoin.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "This field is required")
    @NotEmpty(message = "This field is required")
    @Email(message = "This field require a valid email address")
    private String emailAddress;
    @NotEmpty(message = "This field is required")
    @NotNull(message = "This field is required")
    private String firstName;
    private String lastName;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean isDisabled = true;




    public User(String emailAddress, String firstName, String lastName, String password, UserRole userRole) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
    }
}
