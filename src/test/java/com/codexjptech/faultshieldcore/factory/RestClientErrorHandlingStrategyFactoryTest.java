package com.codexjptech.faultshieldcore.factory;

import com.codexjptech.faultshieldcore.strategy.BadRequestErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.ForbiddenErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.IRestClientErrorHandlingStrategy;
import com.codexjptech.faultshieldcore.strategy.InternalServerErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.NotFoundErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.PreconditionFailedErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.RestClientErrorHandlingStrategyBase;
import com.codexjptech.faultshieldcore.strategy.ServiceUnavailableErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.UnauthorizedErrorHandlingStrategyImpl;
import feign.Response;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestClientErrorHandlingStrategyFactoryTest {

    @Mock
    private Response response;

    @ParameterizedTest(name = "Scenario {index} -> HTTP code: {arguments}")
    @MethodSource("provideHttpStatusCodes")
    void getHandlingStrategyBadRequestTest(Map<Integer, RestClientErrorHandlingStrategyBase> httpCode){

        // *** GIVEN ***
        int statusCode = httpCode.keySet().iterator().next();
        RestClientErrorHandlingStrategyBase handling = httpCode.get(statusCode);

        RestClientErrorHandlingStrategyFactory factory = new RestClientErrorHandlingStrategyFactory();

        // *** WHEN ***
        when(response.status()).thenReturn(statusCode);
        when(response.request()).thenReturn(mock(feign.Request.class));

        IRestClientErrorHandlingStrategy strategy = factory.getHandlingStrategy(response);

        // *** THEN ***
        assertEquals(handling.getClass(), strategy.getClass());
    }

    private static Stream<Map<Integer, RestClientErrorHandlingStrategyBase>> provideHttpStatusCodes(){

        //Response response = Response.builder().build();
        Response response = mock(feign.Response.class);

        when(response.status()).thenReturn(HttpStatus.OK.value());
        when(response.request()).thenReturn(mock(feign.Request.class));

        return Stream.of(
            createErrorHandlingMap(
                    HttpStatus.BAD_REQUEST.value(), new BadRequestErrorHandlingStrategyImpl(response)
            ),
            createErrorHandlingMap(
                    HttpStatus.UNAUTHORIZED.value(), new UnauthorizedErrorHandlingStrategyImpl(response)
            ),
            createErrorHandlingMap(
                    HttpStatus.FORBIDDEN.value(), new ForbiddenErrorHandlingStrategyImpl(response)
            ),
            createErrorHandlingMap(
                    HttpStatus.NOT_FOUND.value(), new NotFoundErrorHandlingStrategyImpl(response)
            ),
            createErrorHandlingMap(
                    HttpStatus.PRECONDITION_FAILED.value(), new PreconditionFailedErrorHandlingStrategyImpl(response)
            ),
            createErrorHandlingMap(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(), new InternalServerErrorHandlingStrategyImpl(response)
            ),
            createErrorHandlingMap(
                    HttpStatus.SERVICE_UNAVAILABLE.value(), new ServiceUnavailableErrorHandlingStrategyImpl(response)
            )
        );
    }

    private static Map<Integer, RestClientErrorHandlingStrategyBase> createErrorHandlingMap(
            Integer key,
            RestClientErrorHandlingStrategyBase value
    ){
            return Collections.singletonMap(key, value);
    }
}