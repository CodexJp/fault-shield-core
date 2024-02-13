package com.codexjptech.faultshieldcore.exception.app;

import com.codexjptech.faultshieldcore.enums.app.ControllerErrorCodeEnum;
import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExceptionHandlerControllerExTest {

    @Test
    void exceptionHandlerControllerExTest(){

        // *** GIVEN ***
        String message = "This is a custom exception example";
        IGlobalErrorCodeBuilder errorCode = ControllerErrorCodeEnum.ERROR_EXAMPLE;

        // *** WHEN ***
        ExceptionHandlerControllerEx exception =
                new ExceptionHandlerControllerEx(
                        message,
                        errorCode
                );

        // *** THEN ***
        assertEquals(message, exception.getMessage());
    }
}