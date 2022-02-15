//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.WebAttributes;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
//import org.springframework.security.web.savedrequest.RequestCache;
//import org.springframework.security.web.savedrequest.SavedRequest;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//
//    private RequestCache requestCache = new HttpSessionRequestCache();
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    @Override
//    public void onAuthenticationSuccess(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Authentication authentication) throws IOException, ServletException {
//
//
//        //redirect
//        resultRedirectStrategy(request, response, authentication);
//        //로그인 실패한 에러 지우기
//        clearAuthenticationAttributes(request);
//    }
//
//
//    protected void resultRedirectStrategy(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Authentication authentication) throws IOException, ServletException {
//        SavedRequest savedRequest = requestCache.getRequest(request,response);
//
//        if(savedRequest != null) {
//            //인증 권한이 필요한 페이지에 접근했을 경우
//            //로그인 화면을 보기 전에 갔던 url로
//            String targetUrl = savedRequest.getRedirectUrl();
//            redirectStrategy.sendRedirect(request, response, targetUrl);
//        } else {
//            //로그인 화면에서 로그인시
//            redirectStrategy.sendRedirect(request, response, "/boards");
//        }
//    }
//
//    private void clearAuthenticationAttributes(HttpServletRequest request) {
//        //세션을 받아옴
//        HttpSession session = request.getSession(false);
//        //세션이 null, 즉 에러가 없는 경우
//        if (session == null) return;
//        //WebAttributes.AUTHENTICATION_EXCEPTION 으로 정의된 세션을 지운다.
//        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//    }
//}
