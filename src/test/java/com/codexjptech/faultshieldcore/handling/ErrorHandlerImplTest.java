package com.codexjptech.faultshieldcore.handling;

import com.codexjptech.faultshieldcore.enums.ErrorExceptionCodeEnum;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ErrorHandlerImplTest {

    private static ErrorHandlerImpl errorHandler;
    private static IGlobalErrorCodeBuilder globalErrorCodeBuilder;

    @BeforeAll
    static void setup(){
        errorHandler = new ErrorHandlerImpl();
        globalErrorCodeBuilder = mock(ErrorExceptionCodeEnum.class);
        errorHandler.setGlobalErrorCodeBuilder(globalErrorCodeBuilder);
    }

    @ParameterizedTest
    @MethodSource("getErrorMessages")
    void errorHandlerTest(Map<String, ErrorExceptionCodeEnum> exceptionMessages){

        // *** GIVEN ***
        String message = exceptionMessages.keySet().iterator().next();
        ErrorExceptionCodeEnum errorCodeEnum = exceptionMessages.get(message);

        Error error = new Error(message);

        GlobalErrorMappers errorMappers = mock(GlobalErrorMappers.class);
        errorHandler.setGlobalErrorMappers(errorMappers);

        // *** WHEN ***
        when(globalErrorCodeBuilder.getEnumName())
                .thenReturn(errorCodeEnum.getEnumName());

        errorHandler.handle(error);

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());
    }

    private static Stream<Map<String, ErrorExceptionCodeEnum>> getErrorMessages(){
        return Stream.of(
                buildErrorMessageMap(
                        "This is a No Such Method Error",
                        ErrorExceptionCodeEnum.ERROR_NO_SUCH_METHOD
                ),
                buildErrorMessageMap(
                        "This is a Out Of Memory Error",
                        ErrorExceptionCodeEnum.ERROR_OUT_OF_MEMORY
                ),
                buildErrorMessageMap(
                        "This is a Stack Overflow Error",
                        ErrorExceptionCodeEnum.ERROR_STACK_OVERFLOW
                ),
                buildErrorMessageMap(
                        "This is a Virtual Machine Error",
                        ErrorExceptionCodeEnum.ERROR_VIRTUAL_MACHINE
                ),
                buildErrorMessageMap(
                        "This is a Assertion Error",
                        ErrorExceptionCodeEnum.ERROR_ASSERTION
                ),
                buildErrorMessageMap(
                        "This is a No Class Def Found Error",
                        ErrorExceptionCodeEnum.ERROR_NO_CLASS_DEF_FOUND
                ),
                buildErrorMessageMap(
                        "This is a Linkage Error",
                        ErrorExceptionCodeEnum.ERROR_LINKAGE
                ),
                buildErrorMessageMap(
                        "This is a Exception In Initializer Error",
                        ErrorExceptionCodeEnum.ERROR_EXCEPTION_IN_INITIALIZER
                )
        );
    }

    private static Map<String, ErrorExceptionCodeEnum> buildErrorMessageMap(
            String message,
            ErrorExceptionCodeEnum errorCodeEnum
    ) {
        return Collections.singletonMap(
                message,
                errorCodeEnum
        );
    }
}