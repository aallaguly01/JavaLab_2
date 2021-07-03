//package ru.itis.rest.security.token;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import ru.itis.rest.security.details.UserDetailsImpl;
//
//import java.util.Collection;
//
//public class JWTAuthentication implements Authentication {
//    private final String userId;
//
//    private UserDetailsImpl userDetails;
//
//    public JWTAuthentication(long userId) {
//        this.userId = userId;
//    }
//
//    public void setUserDetails(UserDetails userDetails) {
//        this.userDetails = (UserDetailsImpl)userDetails;
//    }
//
//    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
//        return userDetails.getAuthorities();
//    }
//
//    @Override public Object getCredentials() {
//        return userDetails.getPassword();
//    }
//
//    @Override public Object getDetails() {
//        return userDetails;
//    }
//
//    public long getUserId() {
//        return userId;
//    }
//
//    @Override
//    public Long getPrincipal() {
//        if (userDetails != null) {
//            return userDetails.getUser();
//        } else return null;
//    }
//
//    @Override public boolean isAuthenticated() {
//        return isAuthenticated;
//    }
//
//    @Override public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
//        this.isAuthenticated = isAuthenticated;
//    }
//
//    @Override public String getName() {
//        return token;
//    }
//}
