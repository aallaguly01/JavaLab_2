//package ru.itis.api.security.jwt.filters;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import ru.itis.api.dto.TokenDto;
//import ru.itis.api.services.JwtRefreshTokenService;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtRefreshTokenFilter extends OncePerRequestFilter {
//
//    private final RequestMatcher refreshRequest = new AntPathRequestMatcher("/refresh", "GET");
//
//
//    @Autowired
//    private JwtRefreshTokenService refreshToken;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//        if (refreshRequest.matches(request)) {
//
//            String token = request.getHeader("refresh");
//
//
//            if (token != null){
//                TokenDto tokenDto = refreshToken.refresh(token);
//                System.err.println(tokenDto);
//                response.setHeader("asd", String.valueOf(tokenDto));
//
//            }
//
//            filterChain.doFilter(request, response);
//
//        }
//
//
//        filterChain.doFilter(request, response);
//    }
//}
