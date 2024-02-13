package com.codexjptech.faultshieldcore.handling;

import com.codexjptech.faultshieldcore.enums.app.ControllerErrorCodeEnum;
import com.codexjptech.faultshieldcore.exception.app.ExceptionHandlerControllerEx;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationExceptionHandlerImplTest {

    @Test
    void applicationExceptionHandle(){

        // *** GIVEN ***
        ApplicationExceptionHandlerImpl applicationExceptionHandler = new ApplicationExceptionHandlerImpl();

        ExceptionHandlerControllerEx exception = new ExceptionHandlerControllerEx(
                "This is a custom exception example",
                ControllerErrorCodeEnum.ERROR_EXAMPLE
        );

        GlobalErrorMappers errorMappers = mock(GlobalErrorMappers.class);
        applicationExceptionHandler.setGlobalErrorMappers(errorMappers);

        // *** WHEN ***
        applicationExceptionHandler.handle(exception);

        // *** THEN ***
        assertEquals(exception.getClass(), applicationExceptionHandler.globalApplicationException.getClass());
    }
}