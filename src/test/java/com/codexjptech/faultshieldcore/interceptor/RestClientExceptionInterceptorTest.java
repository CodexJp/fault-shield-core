package com.codexjptech.faultshieldcore.interceptor;

import com.codexjptech.faultshieldcore.exception.BadRequestException;
import com.codexjptech.faultshieldcore.exception.ForbiddenException;
import com.codexjptech.faultshieldcore.exception.InternalServerErrorException;
import com.codexjptech.faultshieldcore.exception.NotFoundException;
import com.codexjptech.faultshieldcore.exception.PreconditionFailedException;
import com.codexjptech.faultshieldcore.exception.ServiceUnavailableException;
import com.codexjptech.faultshieldcore.exception.UnauthorizedException;
import com.codexjptech.faultshieldcore.handling.RestClientErrorDecoderHandler;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import feign.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestClientExceptionInterceptorTest {

    @Mock
    private Response response;

    @InjectMocks
    private static RestClientErrorDecoderHandler decoderHandler;

    private static RestClientExceptionInterceptor restClientExceptionInterceptor;

    @BeforeAll
    static void setup(){

        decoderHandler = new RestClientErrorDecoderHandler();

        restClientExceptionInterceptor = new RestClientExceptionInterceptor();
        GlobalErrorMappers errorMappers = mock(GlobalErrorMappers.class);

        restClientExceptionInterceptor.setGlobalErrorMappers(errorMappers);
    }

    @Test
    void badRequestExceptionInterceptorTest(){

        // *** GIVEN ***
        Integer httpErrorCode = HttpStatus.BAD_REQUEST.value();
        Object httpStatus = BadRequestException.class;
        String methodKey = "RestClientErrorDecoderHandler.decode()";

        // *** WHEN ***
        when(response.status()).thenReturn(httpErrorCode);
        when(response.request()).thenReturn(mock(feign.Request.class));

        BadRequestException exception = (BadRequestException) decoderHandler.decode(methodKey, response);
        restClientExceptionInterceptor.handleBadRequestException(exception);

        // *** THEN ***
        assertEquals(exception.getClass(), httpStatus);
    }

    @Test
    void unauthorizedExceptionInterceptorTest(){

        // *** GIVEN ***
        Integer httpErrorCode = HttpStatus.UNAUTHORIZED.value();
        Object httpStatus = UnauthorizedException.class;
        String methodKey = "RestClientErrorDecoderHandler.decode()";

        // *** WHEN ***
        when(response.status()).thenReturn(httpErrorCode);
        when(response.request()).thenReturn(mock(feign.Request.class));

        UnauthorizedException exception = (UnauthorizedException) decoderHandler.decode(methodKey, response);
        restClientExceptionInterceptor.handleUnauthorizedException(exception);

        // *** THEN ***
        assertEquals(exception.getClass(), httpStatus);
    }

    @Test
    void forbiddenExceptionInterceptorTest(){

        // *** GIVEN ***
        Integer httpErrorCode = HttpStatus.FORBIDDEN.value();
        Object httpStatus = ForbiddenException.class;
        String methodKey = "RestClientErrorDecoderHandler.decode()";

        // *** WHEN ***
        when(response.status()).thenReturn(httpErrorCode);
        when(response.request()).thenReturn(mock(feign.Request.class));

        ForbiddenException exception = (ForbiddenException) decoderHandler.decode(methodKey, response);
        restClientExceptionInterceptor.handleForbiddenException(exception);

        // *** THEN ***
        assertEquals(exception.getClass(), httpStatus);
    }

    @Test
    void notFoundExceptionInterceptorTest(){

        // *** GIVEN ***
        Integer httpErrorCode = HttpStatus.NOT_FOUND.value();
        Object httpStatus = NotFoundException.class;
        String methodKey = "RestClientErrorDecoderHandler.decode()";

        // *** WHEN ***
        when(response.status()).thenReturn(httpErrorCode);
        when(response.request()).thenReturn(mock(feign.Request.class));

        NotFoundException exception = (NotFoundException) decoderHandler.decode(methodKey, response);
        restClientExceptionInterceptor.handleNotFoundException(exception);

        // *** THEN ***
        assertEquals(exception.getClass(), httpStatus);
    }

    @Test
    void preconditionFailedExceptionInterceptorTest(){

        // *** GIVEN ***
        Integer httpErrorCode = HttpStatus.PRECONDITION_FAILED.value();
        Object httpStatus = PreconditionFailedException.class;
        String methodKey = "RestClientErrorDecoderHandler.decode()";

        // *** WHEN ***
        when(response.status()).thenReturn(httpErrorCode);
        when(response.request()).thenReturn(mock(feign.Request.class));

        PreconditionFailedException exception = (PreconditionFailedException) decoderHandler.decode(methodKey, response);
        restClientExceptionInterceptor.handlePreconditionFailedException(exception);

        // *** THEN ***
        assertEquals(exception.getClass(), httpStatus);
    }

    @Test
    void internalServerErrorExceptionInterceptorTest(){

        // *** GIVEN ***
        Integer httpErrorCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        Object httpStatus = InternalServerErrorException.class;
        String methodKey = "RestClientErrorDecoderHandler.decode()";

        // *** WHEN ***
        when(response.status()).thenReturn(httpErrorCode);
        when(response.request()).thenReturn(mock(feign.Request.class));

        InternalServerErrorException exception = (InternalServerErrorException) decoderHandler.decode(methodKey, response);
        restClientExceptionInterceptor.handleInternalServerErrorException(exception);

        // *** THEN ***
        assertEquals(exception.getClass(), httpStatus);
    }

    @Test
    void serviceUnavailableExceptionInterceptorTest(){

        // *** GIVEN ***
        Integer httpErrorCode = HttpStatus.SERVICE_UNAVAILABLE.value();
        Object httpStatus = ServiceUnavailableException.class;
        String methodKey = "RestClientErrorDecoderHandler.decode()";

        // *** WHEN ***
        when(response.status()).thenReturn(httpErrorCode);
        when(response.request()).thenReturn(mock(feign.Request.class));

        ServiceUnavailableException exception = (ServiceUnavailableException) decoderHandler.decode(methodKey, response);
        restClientExceptionInterceptor.handleServiceUnavailableException(exception);

        // *** THEN ***
        assertEquals(exception.getClass(), httpStatus);
    }
}