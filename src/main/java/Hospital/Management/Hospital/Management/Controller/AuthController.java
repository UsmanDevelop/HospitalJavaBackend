package Hospital.Management.Hospital.Management.Controller;

import Hospital.Management.Hospital.Management.Dto.LoginRequestDto;
import Hospital.Management.Hospital.Management.Dto.LoginResponseDto;
import Hospital.Management.Hospital.Management.Dto.SignupRequestDto;
import Hospital.Management.Hospital.Management.Dto.SignupResponseDto;
import Hospital.Management.Hospital.Management.Security.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        LoginResponseDto response = authService.login(loginRequestDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<SignupResponseDto> signup(@Valid @RequestBody SignupRequestDto signupRequestDto)
            throws IllegalAccessException {
        SignupResponseDto signupResponseDto = authService.signup(signupRequestDto);
        return ResponseEntity.ok(signupResponseDto);
    }
}
