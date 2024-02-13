package com.codexjptech.faultshieldcore.handling;

import com.codexjptech.faultshieldcore.exception.BadRequestException;
import com.codexjptech.faultshieldcore.exception.ForbiddenException;
import com.codexjptech.faultshieldcore.exception.GlobalRestClientException;
import com.codexjptech.faultshieldcore.exception.InternalServerErrorException;
import com.codexjptech.faultshieldcore.exception.NotFoundException;
import com.codexjptech.faultshieldcore.exception.PreconditionFailedException;
import com.codexjptech.faultshieldcore.exception.ServiceUnavailableException;
import com.codexjptech.faultshieldcore.exception.UnauthorizedException;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import com.codexjptech.faultshieldcore.strategy.BadRequestErrorHandlingStrategyImpl;
import feign.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestClientExceptionHandlerImplTest {

    @Mock
    private Response response;

    @InjectMocks
    private static RestClientErrorDecoderHandler decoderHandler;

    @BeforeAll
    static void setup(){
        decoderHandler = new RestClientErrorDecoderHandler();
    }

    @ParameterizedTest
    @MethodSource("getErrorMessages")
    void restClientExceptionHandleTest(Map<Integer, Object> httpErrorCodes){

        // *** GIVEN ***
        RestClientExceptionHandlerImpl restClientExceptionHandler = new RestClientExceptionHandlerImpl();

        Integer httpErrorCode = httpErrorCodes.keySet().iterator().next();
        Object httpStatus = httpErrorCodes.get(httpErrorCode);
        String methodKey = "RestClientErrorDecoderHandler.decode()";

        // *** WHEN ***
        when(response.status()).thenReturn(httpErrorCode);
        when(response.request()).thenReturn(mock(feign.Request.class));

        GlobalErrorMappers errorMappers = mock(GlobalErrorMappers.class);
        restClientExceptionHandler.setGlobalErrorMappers(errorMappers);

        Exception exception = decoderHandler.decode(methodKey, response);
        restClientExceptionHandler.handle(exception);

        // *** THEN ***
        assertEquals(exception.getClass(), httpStatus);
        assertEquals(exception.getMessage(), restClientExceptionHandler.globalApplicationException.getMessage());
    }

    private static Stream<Map<Integer, Object>> getErrorMessages(){
        return Stream.of(
                buildErrorMessageMap(HttpStatus.BAD_REQUEST.value(), BadRequestException.class),
                buildErrorMessageMap(HttpStatus.FORBIDDEN.value(), ForbiddenException.class),
                buildErrorMessageMap(HttpStatus.INTERNAL_SERVER_ERROR.value(), InternalServerErrorException.class),
                buildErrorMessageMap(HttpStatus.NOT_FOUND.value(), NotFoundException.class),
                buildErrorMessageMap(HttpStatus.PRECONDITION_FAILED.value(), PreconditionFailedException.class),
                buildErrorMessageMap(HttpStatus.SERVICE_UNAVAILABLE.value(), ServiceUnavailableException.class),
                buildErrorMessageMap(HttpStatus.UNAUTHORIZED.value(), UnauthorizedException.class)
        );
    }

    private static Map<Integer, Object> buildErrorMessageMap(
            Integer httpErrorCode,
            Object httpStatus
    ){
        return Collections.singletonMap(
                httpErrorCode,
                httpStatus
        );
    }
}