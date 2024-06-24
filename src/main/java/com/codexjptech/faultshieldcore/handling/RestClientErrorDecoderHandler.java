package com.codexjptech.faultshieldcore.handling;

import com.codexjptech.faultshieldcore.factory.RestClientErrorHandlingStrategyFactory;
import com.codexjptech.faultshieldcore.strategy.IRestClientErrorHandlingStrategy;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Funciona como cliente de la fábrica de objetos de
 * estrategia de excepciones de tipo HTTP
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
@Component
public class RestClientErrorDecoderHandler implements ErrorDecoder {

    private final RestClientErrorHandlingStrategyFactory factory = new RestClientErrorHandlingStrategyFactory();

    @Override
    public Exception decode(String methodKey, Response response) {

        IRestClientErrorHandlingStrategy strategy = factory.getHandlingStrategy(response);
        return strategy.handle(response);
    }
}
