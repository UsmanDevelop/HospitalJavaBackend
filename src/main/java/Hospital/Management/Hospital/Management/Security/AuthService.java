package Hospital.Management.Hospital.Management.Security;

import Hospital.Management.Hospital.Management.Dto.LoginRequestDto;
import Hospital.Management.Hospital.Management.Dto.LoginResponseDto;
import Hospital.Management.Hospital.Management.Dto.SignupRequestDto;
import Hospital.Management.Hospital.Management.Dto.SignupResponseDto;
import Hospital.Management.Hospital.Management.Entity.User;
import Hospital.Management.Hospital.Management.Repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authenticationManager, AuthUtil authUtil, UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.authUtil = authUtil;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDto login (LoginRequestDto loginRequestDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateKey(user);

        return new LoginResponseDto(token, user.getId());
    }

    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {

        User user = userRepo.findUserByUsername(signupRequestDto.getUsername()).orElse(null);

        if(user != null) throw new IllegalArgumentException("User already exists!");

        user = userRepo.save(User.builder()
                .username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .build()
        );

        return new SignupResponseDto(user.getId(), user.getUsername());
    }
}
