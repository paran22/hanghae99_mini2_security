//package com.example.hanghae99_mini2.security;
//
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.context.HttpRequestResponseHolder;
//import org.springframework.security.web.context.SecurityContextPersistenceFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//public class CustomFilter extends SecurityContextPersistenceFilter {
//
//
//
//    @Override
//    public void doFilter(ServletRequest request,
//                         ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//
//
//            HttpSession session = request.getSession();
//
//
//
//        final boolean debug = logger.isDebugEnabled();
//
//        request.setAttribute(FILTER_APPLIED, Boolean.TRUE);
//
//        if (forceEagerSessionCreation) {
//            HttpSession session = request.getSession();
//
//            if (debug && session.isNew()) {
//                logger.debug("Eagerly created session: " + session.getId());
//            }
//        }
//
//        HttpRequestResponseHolder holder = new HttpRequestResponseHolder(request, response);
//        SecurityContext contextBeforeChainExecution = repo.loadContext(holder);
//
//        try {
//            SecurityContextHolder.setContext(contextBeforeChainExecution);
//
//            chain.doFilter(holder.getRequest(), holder.getResponse());
//
//        } finally {
//            SecurityContext contextAfterChainExecution = SecurityContextHolder.getContext();
//            // Crucial removal of SecurityContextHolder contents - do this before anything else.
//            SecurityContextHolder.clearContext();
//            repo.saveContext(contextAfterChainExecution, holder.getRequest(), holder.getResponse());
//            request.removeAttribute(FILTER_APPLIED);
//
//            if (debug) {
//                logger.debug("SecurityContextHolder now cleared, as request processing completed");
//            }
//        }
//    }
//
