package com.mtbp.users.web.advices;

import com.mtbp.commons.web.ApiError;
import com.mtbp.db.exceptions.DocumentNotFoundException;
import com.mtbp.users.exceptions.UserExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DocumentNotFoundException.class})
    protected ResponseEntity<ApiError> crmServiceException(DocumentNotFoundException ex) {
        log.error("", ex);
        return createResponse(ex.getMessage(), HttpStatus.NOT_FOUND, 1000);
    }

    @ExceptionHandler({UserExistsException.class})
    protected ResponseEntity<ApiError> crmServiceException(UserExistsException ex) {
        log.error("", ex);
        return createResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, 1001);
    }

    private ResponseEntity<ApiError> createResponse(String errorInfo, HttpStatus status, int errorCode) {
        ApiError apiError = ApiError.builder()
            .errorInfo(errorInfo)
            .errorCode(errorCode)
            .build();
        return ResponseEntity.status(status).body(apiError);
    }
}
