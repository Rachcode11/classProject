package africa.semicolon.uncoin.user;

import africa.semicolon.uncoin.registration.token.ConfirmationToken;
import africa.semicolon.uncoin.registration.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired

    private ConfirmationTokenService confirmationTokenService;



    @Override
    public String createAccount(User user) {
        var savedUser = userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),
                savedUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;

    }
}
