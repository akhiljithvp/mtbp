package com.mtbp.movies.web.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtbp.commons.web.ApiError;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HeaderFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().startsWith("/apis")) {
            String sessionHeader = request.getHeader("X-Session-ID");
            if (StringUtils.isEmpty(sessionHeader)) {
                ApiError apiError = ApiError.builder()
                    .errorCode(100)
                    .errorInfo("Required header X-Session-ID is not present")
                    .build();
                response.reset();
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getOutputStream().println(objectMapper.writeValueAsString(apiError));
            } else {
                filterChain.doFilter(request, response);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}