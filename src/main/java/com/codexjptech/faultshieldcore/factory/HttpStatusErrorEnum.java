package com.codexjptech.faultshieldcore.factory;

import com.codexjptech.faultshieldcore.strategy.BadRequestErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.ForbiddenErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.IRestClientErrorHandlingStrategy;
import com.codexjptech.faultshieldcore.strategy.InternalServerErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.NotFoundErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.PreconditionFailedErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.ServiceUnavailableErrorHandlingStrategyImpl;
import com.codexjptech.faultshieldcore.strategy.UnauthorizedErrorHandlingStrategyImpl;
import feign.Response;
import org.springframework.http.HttpStatus;

import java.util.function.Function;

/**
 * Enumeración de errores HTTP más comunes.
 * Usado para retornar o crear productos de tipo
 * concreto que implementan la interfaz
 * IRestClientErrorHandlingStrategy
 * <br/><br/>
 *
 * Copyright 2023 Jairo Polo <contacto.jairopolo@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <br/><br/>
 *
 * @author  Jairo Polo
 * @since 0.0.1
 */
public enum HttpStatusErrorEnum {

    BAD_REQUEST             (HttpStatus.BAD_REQUEST, BadRequestErrorHandlingStrategyImpl::new),
    UNAUTHORIZED            (HttpStatus.UNAUTHORIZED, UnauthorizedErrorHandlingStrategyImpl::new),
    FORBIDDEN               (HttpStatus.FORBIDDEN, ForbiddenErrorHandlingStrategyImpl::new),
    NOT_FOUND               (HttpStatus.NOT_FOUND, NotFoundErrorHandlingStrategyImpl::new),
    PRECONDITION_FAILED     (HttpStatus.PRECONDITION_FAILED, PreconditionFailedErrorHandlingStrategyImpl::new),
    INTERNAL_SERVER_ERROR   (HttpStatus.INTERNAL_SERVER_ERROR, InternalServerErrorHandlingStrategyImpl::new),
    SERVICE_UNAVAILABLE     (HttpStatus.SERVICE_UNAVAILABLE, ServiceUnavailableErrorHandlingStrategyImpl::new);

    private final HttpStatus httpStatus;
    private final Function<Response, IRestClientErrorHandlingStrategy> strategyConstructor;

    HttpStatusErrorEnum(
        HttpStatus httpStatus,
        Function<Response, IRestClientErrorHandlingStrategy> strategyConstructor
    ) {
        this.httpStatus = httpStatus;
        this.strategyConstructor = strategyConstructor;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public IRestClientErrorHandlingStrategy getStrategy(Response response) {
        return strategyConstructor.apply(response);
    }
}
