package com.codexjptech.faultshieldcore.exception;

/**
 * Clase de excepción personalizada para errores HTTP
 * <br/><br/>
 * 5xx Generic server error.
 * <br/>
 * HttpStatus : 500 Internal Server Error
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
public class InternalServerErrorException extends GlobalRestClientException {

    public InternalServerErrorException(
            String code,
            String status,
            String error,
            String message,
            String path,
            Object details) {

        super(code, status, error, message, path, details);
    }
}
