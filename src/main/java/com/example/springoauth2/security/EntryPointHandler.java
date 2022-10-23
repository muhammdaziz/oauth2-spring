package com.example.springoauth2.security;

import com.example.springoauth2.payload.ApiResult;
import com.example.springoauth2.payload.ErrorData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class EntryPointHandler implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        ApiResult<List<ErrorData>> result = ApiResult.failResponse(
                "Full authentication is required to access this resource",
                HttpStatus.UNAUTHORIZED.value());

        String error = objectMapper.writeValueAsString(result);

        response.getWriter().write(error);
        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
