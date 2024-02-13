package com.codexjptech.faultshieldcore.interceptor;

import com.codexjptech.faultshieldcore.enums.app.ControllerErrorCodeEnum;
import com.codexjptech.faultshieldcore.exception.app.ExceptionHandlerControllerEx;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ApplicationExceptionInterceptorTest {

    @Test
    void applicationExceptionInterceptorTest(){

        // *** GIVEN ***
        ApplicationExceptionInterceptor applicationExceptionInterceptor =
                new ApplicationExceptionInterceptor();

        GlobalErrorMappers errorMappers = mock(GlobalErrorMappers.class);
        applicationExceptionInterceptor.setGlobalErrorMappers(errorMappers);

        ExceptionHandlerControllerEx exception = new ExceptionHandlerControllerEx(
                "This is a custom exception example",
                ControllerErrorCodeEnum.ERROR_EXAMPLE
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                applicationExceptionInterceptor.handleGlobalApplicationException(exception);

        // *** THEN ***
        assertEquals(response.getStatusCode().value(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}