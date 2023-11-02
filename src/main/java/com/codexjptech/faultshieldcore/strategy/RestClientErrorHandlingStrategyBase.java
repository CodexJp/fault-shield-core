package com.codexjptech.faultshieldcore.strategy;

import feign.Response;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;

/**
 * Sirve como objeto de transporte para la implementación
 * de estrategias de administración de errores HTTP
 * en tiempo de ejecución
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
@Getter
public abstract class RestClientErrorHandlingStrategyBase implements IRestClientErrorHandlingStrategy{

    private final String code;
    private final String status;
    private final String error;
    private final String message;
    private final String path;
    private final Object details;

    protected RestClientErrorHandlingStrategyBase(String code, String error, Response response) {
        this.code       = code;
        this.status     = String.valueOf(HttpStatus.valueOf(response.status()).value());
        this.error      = error;
        this.message    = HttpStatus.valueOf(response.status()).getReasonPhrase();
        this.path       = response.request().url();
        this.details    = Collections.emptyList();
    }
}
