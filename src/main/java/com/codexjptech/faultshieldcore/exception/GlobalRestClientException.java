package com.codexjptech.faultshieldcore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Funciona como objeto de transporte para los datos de
 * nuestras excepciones HTTP personalizadas
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
@AllArgsConstructor
public class GlobalRestClientException extends RuntimeException{

    private final String code;            // Código interno del error
    private final String status;          // código HTTP del error
    private final String error;           // Causa del error
    private final String message;         // Mensaje de error
    private final String path;            // Ruta que se intenta acceder
    private final Object details;         // Detalle del error
}
