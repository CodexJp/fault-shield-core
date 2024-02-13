package com.codexjptech.faultshieldcore.handling;

import com.codexjptech.faultshieldcore.enums.UncheckedExceptionErrorCodeEnum;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UncheckedExceptionHandlerImplTest {

    private static UncheckedExceptionHandlerImpl uncheckedExceptionHandler;
    private static IGlobalErrorCodeBuilder globalErrorCodeBuilder;
    private static GlobalErrorMappers errorMappers;

    @BeforeAll
    static void setup(){

        uncheckedExceptionHandler = new UncheckedExceptionHandlerImpl();

        globalErrorCodeBuilder = mock(UncheckedExceptionErrorCodeEnum.class);
        uncheckedExceptionHandler.setGlobalErrorCodeBuilder(globalErrorCodeBuilder);

        errorMappers = mock(GlobalErrorMappers.class);
        uncheckedExceptionHandler.setGlobalErrorMappers(errorMappers);
    }

    @ParameterizedTest
    @MethodSource("getErrorMessages")
    void uncheckedExceptionHandleTest(Map<String, UncheckedExceptionErrorCodeEnum> exceptionMessages){

        // *** GIVEN ***
        String message = exceptionMessages.keySet().iterator().next();
        UncheckedExceptionErrorCodeEnum errorCodeEnum = exceptionMessages.get(message);

        Exception exception = new Exception(message);

        // *** WHEN ***
        when(globalErrorCodeBuilder.getEnumName())
                .thenReturn(errorCodeEnum.name());

        uncheckedExceptionHandler.handle(exception);

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());
    }

    @Test
    void nullPointerExceptionHandleTest(){

        // *** GIVEN ***
        String message = "Null pointer exception";

        UncheckedExceptionErrorCodeEnum errorCodeEnum =
                UncheckedExceptionErrorCodeEnum.ERROR_NULL_POINTER_EXCEPTION;

        NullPointerException exception = new NullPointerException(message);

        // *** WHEN ***
        when(globalErrorCodeBuilder.getEnumName())
                .thenReturn(errorCodeEnum.name());

        uncheckedExceptionHandler.handle(exception);

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());
    }

    @Test
    void withoutMessageExceptionHandleTest(){

        // *** GIVEN ***
        String message = null;

        UncheckedExceptionErrorCodeEnum errorCodeEnum =
                UncheckedExceptionErrorCodeEnum.ERROR_ARITHMETIC_EXCEPTION;

        Exception exception = new Exception(message);

        // *** WHEN ***
        when(globalErrorCodeBuilder.getEnumName())
                .thenReturn(errorCodeEnum.name());

        uncheckedExceptionHandler.handle(exception);

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());
    }

    private static Stream<Map<String, UncheckedExceptionErrorCodeEnum>> getErrorMessages(){

        return Stream.of(
                buildErrorMessageMap(
                        "This is a Null Pointer Exception",
                        UncheckedExceptionErrorCodeEnum.ERROR_NULL_POINTER_EXCEPTION
                ),
                buildErrorMessageMap(
                        "This is a Arithmetic Exception",
                        UncheckedExceptionErrorCodeEnum.ERROR_ARITHMETIC_EXCEPTION
                ),
                buildErrorMessageMap(
                        "This is a Array Index Of Bounds Exception",
                        UncheckedExceptionErrorCodeEnum.ERROR_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION
                ),
                buildErrorMessageMap(
                        "This is a Illegal Argument Exception",
                        UncheckedExceptionErrorCodeEnum.ERROR_ILLEGAL_ARGUMENT_EXCEPTION
                ),
                buildErrorMessageMap(
                        "This is a Concurrent Modification Exception",
                        UncheckedExceptionErrorCodeEnum.ERROR_CONCURRENT_MODIFICATION_EXCEPTION
                )
        );
    }

    private static Map<String, UncheckedExceptionErrorCodeEnum> buildErrorMessageMap(
            String message,
            UncheckedExceptionErrorCodeEnum errorCodeEnum
    ){
        return Collections.singletonMap(message, errorCodeEnum);
    }
}