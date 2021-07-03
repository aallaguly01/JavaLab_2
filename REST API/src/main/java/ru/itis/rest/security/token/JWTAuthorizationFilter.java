//package ru.itis.rest.security.token;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Date;
//
//public class JWTAuthorizationFilter extends GenericFilterBean {
//
//    private static final String HEADER_STRING = "X-Access-Token";
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        String token = httpRequest.getHeader(HEADER_STRING);
//        if (token != null) {
//            SecurityContextHolder.getContext().setAuthentication();
//        }
//        filterChain.doFilter(httpRequest, httpResponse);
//    }
//    }
//}
