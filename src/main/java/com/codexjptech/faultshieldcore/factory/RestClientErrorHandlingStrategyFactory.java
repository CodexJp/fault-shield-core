package com.codexjptech.faultshieldcore.factory;

import com.codexjptech.faultshieldcore.strategy.IRestClientErrorHandlingStrategy;
import com.codexjptech.faultshieldcore.strategy.InternalServerErrorHandlingStrategyImpl;
import feign.Response;

import java.util.stream.Stream;

/**
 * Clase fábrica de objetos de estrategia de errores
 * HTTP en tiempo de ejecución de nuestra aplicación.
 * Crea productos de tipo concreto que implementan la
 * interfaz IRestClientErrorHandlingStrategy
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
public class RestClientErrorHandlingStrategyFactory {

    public IRestClientErrorHandlingStrategy getHandlingStrategy(Response response){

        Stream<HttpStatusErrorEnum> httpStatusEnumStream = Stream.of(HttpStatusErrorEnum.values());

        return httpStatusEnumStream
                .filter(enumerator -> response.status() == enumerator.getHttpStatus().value())
                .findFirst()
                .map(enumerator -> enumerator.getStrategy(response))
                .orElse(new InternalServerErrorHandlingStrategyImpl(response));
    }
}
