package com.example.backendwebfinal.config;

import com.example.backendwebfinal.service.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

        String redirectURL = request.getContextPath();
        if (userDetails.hasRole("DOCTOR")) {
            redirectURL += "/doctor";
        } else if (userDetails.hasRole("ADMIN"))
            redirectURL += "/admin";

       response.sendRedirect(redirectURL);
    }
}
