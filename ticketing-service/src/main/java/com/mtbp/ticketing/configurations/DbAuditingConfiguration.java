package com.mtbp.ticketing.configurations;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DbAuditingConfiguration implements AuditorAware<String> {

    private final HttpServletRequest httpServletRequest;

    @Override
    public Optional<String> getCurrentAuditor() {
        return httpServletRequest == null
            ? Optional.of("System")
            : Optional.ofNullable(httpServletRequest.getHeader("X-Session-ID"));
    }
}
