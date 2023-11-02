package com.codexjptech.faultshieldcore.exception;

import com.codexjptech.faultshieldcore.model.constant.ApplicationConstants;
import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Collections;

/**
 * Funciona como objeto de transporte para los datos de
 * nuestras excepciones de aplicación personalizadas
 *
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
 * @author Jairo Polo
 * @since 0.0.1
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class GlobalApplicationException extends RuntimeException {

    private final String customExceptionEnumName;   // Nombre personalizado de la excepción
    private final String code;                      // Código interno del error
    private final String status;                    // código HTTP del error
    private final String error;                     // Causa del error
    private final String message;                   // Mensaje de error
    private final String path;                      // Ruta que se intenta acceder
    private final Object details;                   // Detalle del error

    public GlobalApplicationException(String message, IGlobalErrorCodeBuilder errorCodeBuilder) {
        super(message);
        this.code                       = errorCodeBuilder.getCode();
        this.message                    = message;
        this.error                      = ApplicationConstants.SERVER_ERROR;
        this.status                     = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
        this.path                       = ApplicationConstants.EMPTY_STRING;
        this.details                    = Collections.emptyList();
        this.customExceptionEnumName    = errorCodeBuilder.getClass()
                                            .getSimpleName()
                                            .concat(".")
                                            .concat(errorCodeBuilder.getEnumName());
    }
}
