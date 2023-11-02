package com.codexjptech.faultshieldcore.interceptor;

import com.codexjptech.faultshieldcore.exception.GlobalApplicationException;
import com.codexjptech.faultshieldcore.handling.ApplicationExceptionHandlerImpl;
import com.codexjptech.faultshieldcore.model.constant.ApplicationExceptionDetailConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Administrador de las excepciones en tiempo de ejecución
 * de la aplicación. Encapsula los eventos de errores,
 * les da formato y los entrega al cliente que hace la solicitud
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
@ControllerAdvice
public class ApplicationExceptionInterceptor extends ApplicationExceptionHandlerImpl {

    // ********************** APPLICATION EXCEPTIONS **********************

    /**
     * GlobalApplicationException
     */
    @ExceptionHandler(GlobalApplicationException.class)
    protected ResponseEntity<Object> handleGlobalApplicationException(
        GlobalApplicationException exception
    ){

        errorDetailDescription = ApplicationExceptionDetailConstants.APPLICATION_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = ApplicationExceptionDetailConstants.APPLICATION_EXCEPTION_ERROR_SUGGESTION_MESSAGE;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }
}
