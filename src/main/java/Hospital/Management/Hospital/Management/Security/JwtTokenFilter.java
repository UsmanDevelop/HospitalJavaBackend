package Hospital.Management.Hospital.Management.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    private final AuthUtil authUtil;

    public JwtTokenFilter(AuthUtil authUtil) {
        this.authUtil = authUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Incoming request: ${s}", request.getRequestURI());
        String tokenHeader = request.getHeader("Authorization");

        if(tokenHeader == null || !tokenHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = tokenHeader.split("Bearer")[1];

        String username = authUtil.getUsernameFromToken(token);

    }
}
