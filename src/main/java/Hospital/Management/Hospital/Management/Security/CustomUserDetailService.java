package Hospital.Management.Hospital.Management.Security;

import Hospital.Management.Hospital.Management.Entity.User;
import Hospital.Management.Hospital.Management.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findUserByUsername(username).orElseThrow();
    }

}
