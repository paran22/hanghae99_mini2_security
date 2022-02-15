package com.example.hanghae99_mini2.security;

import org.springframework.http.HttpHeaders;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CookieAttributeFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        chain.doFilter(request, response);
        addSameSite(httpServletResponse, "none");
    }

    private void addSameSite(HttpServletResponse response, String sameSite) {
        Collection<String> headers = response.getHeaders(HttpHeaders.SET_COOKIE);
        boolean firstHeader = true;
        for(String header : headers) {
            if(firstHeader) {
                response.setHeader(HttpHeaders.SET_COOKIE,
                        String.format("%s; Secure; %s", header, "SameSite=" + sameSite));
                firstHeader = false;
                continue;
            }
            response.addHeader(HttpHeaders.SET_COOKIE,
                    String.format("%s; Secure; %s", header, "SameSite=" + sameSite));
        }
    }

}
