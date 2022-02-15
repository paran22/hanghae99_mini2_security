//package com.example.hanghae99_mini2.security;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//public class CustomAuthorizationFilter extends BasicAuthenticationFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain chain) throws IOException, ServletException {
//        String header = request.getHeader("Authorization");
//
//        HttpSession session = request.getSession();
//
//    }
//}
