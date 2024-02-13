package com.codexjptech.faultshieldcore.handling;

import com.codexjptech.faultshieldcore.exception.BadRequestException;
import com.codexjptech.faultshieldcore.exception.ForbiddenException;
import com.codexjptech.faultshieldcore.exception.InternalServerErrorException;
import com.codexjptech.faultshieldcore.exception.NotFoundException;
import com.codexjptech.faultshieldcore.exception.PreconditionFailedException;
import com.codexjptech.faultshieldcore.exception.ServiceUnavailableException;
import com.codexjptech.faultshieldcore.exception.UnauthorizedException;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestClientErrorDecoderHandlerTest {

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
    void restClientErrorDecoderHandlerTest(Map<Integer, Object> httpErrorCodes) {

        // *** GIVEN ***
        Integer httpErrorCode = httpErrorCodes.keySet().iterator().next();
        Object httpStatus = httpErrorCodes.get(httpErrorCode);
        String methodKey = "RestClientErrorDecoderHandler.decode()";

        // *** WHEN ***
        when(response.status()).thenReturn(httpErrorCode);
        when(response.request()).thenReturn(mock(feign.Request.class));

        Exception exception = decoderHandler.decode(methodKey, response);

        // *** THEN ***
        assertEquals(exception.getClass(), httpStatus);
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