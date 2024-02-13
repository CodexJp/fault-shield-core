package com.codexjptech.faultshieldcore.handling;

import com.codexjptech.faultshieldcore.enums.CheckedExceptionErrorCodeEnum;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CheckedExceptionHandlerImplTest {

    private static CheckedExceptionHandlerImpl checkedExceptionHandler;
    private static IGlobalErrorCodeBuilder globalErrorCodeBuilder;

    @BeforeAll
    static void setup(){
        checkedExceptionHandler = new CheckedExceptionHandlerImpl();
        globalErrorCodeBuilder = mock(CheckedExceptionErrorCodeEnum.class);
        checkedExceptionHandler.setGlobalErrorCodeBuilder(globalErrorCodeBuilder);
    }

    @ParameterizedTest
    @MethodSource("getErrorMessages")
    void checkedExceptionHandleTest(Map<String, CheckedExceptionErrorCodeEnum> exceptionMessages){

        // *** GIVEN ***
        String message = exceptionMessages.keySet().iterator().next();
        CheckedExceptionErrorCodeEnum errorCodeEnum = exceptionMessages.get(message);

        Exception exception = new Exception(message);

        GlobalErrorMappers errorMappers = mock(GlobalErrorMappers.class);
        checkedExceptionHandler.setGlobalErrorMappers(errorMappers);

        // *** WHEN ***
        when(globalErrorCodeBuilder.getEnumName())
                .thenReturn(errorCodeEnum.name());

        checkedExceptionHandler.handle(exception);

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());
    }

    @Test
    void checkedMethodArgumentNotValidExceptionHandleTest() {

        // *** GIVEN ***
        List<ObjectError> errors = List.of(
            new FieldError(
                "ApplicationMetricRequestDTO",
                "applicationUrl",
                "applicationUrl: Field entity cannot be empty."
            )
        );

        BindingResult bindingResult = new BeanPropertyBindingResult(
                errors,
                "ApplicationMetricRequestDTO"
        );

        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(
                mock(MethodParameter.class),
                bindingResult
        );

        // *** WHEN ***
        when(globalErrorCodeBuilder.getEnumName())
                .thenReturn(CheckedExceptionErrorCodeEnum.ERROR_METHOD_ARGUMENT_NOT_VALID_EXCEPTION.name());

        checkedExceptionHandler.handle(exception);

        // *** THEN ***
        assertEquals(
                checkedExceptionHandler.globalErrorCodeBuilder.getEnumName(),
                CheckedExceptionErrorCodeEnum.ERROR_METHOD_ARGUMENT_NOT_VALID_EXCEPTION.name()
        );
    }

    private static Stream<Map<String, CheckedExceptionErrorCodeEnum>> getErrorMessages(){

        return Stream.of(
                buildErrorMessageMap(
                        "This is a IO Exception",
                        CheckedExceptionErrorCodeEnum.ERROR_IO_EXCEPTION
                ),
                buildErrorMessageMap(
                        "This is a SQL Exception",
                        CheckedExceptionErrorCodeEnum.ERROR_SQL_EXCEPTION
                ),
                buildErrorMessageMap(
                        "This is a Class Not Found Exception",
                        CheckedExceptionErrorCodeEnum.ERROR_CLASS_NOT_FOUND_EXCEPTION
                ),
                buildErrorMessageMap(
                        "This is a Instantiation Exception",
                        CheckedExceptionErrorCodeEnum.ERROR_INSTANTIATION_EXCEPTION
                ),
                buildErrorMessageMap(
                        "This is a Undeclared Throwable Exception",
                        CheckedExceptionErrorCodeEnum.ERROR_UNDECLARED_THROWABLE_EXCEPTION
                ),
                buildErrorMessageMap(
                        "This is a Connection Exception",
                        CheckedExceptionErrorCodeEnum.ERROR_CONNECTION_EXCEPTION
                ),
                buildErrorMessageMap(
                        null,
                        CheckedExceptionErrorCodeEnum.ERROR_SQL_EXCEPTION
                )
        );
    }

    private static Map<String, CheckedExceptionErrorCodeEnum> buildErrorMessageMap(
            String message,
            CheckedExceptionErrorCodeEnum errorCodeEnum
    ){
        return Collections.singletonMap(message, errorCodeEnum);
    }
}