package com.codexjptech.faultshieldcore.exception.app;

import com.codexjptech.faultshieldcore.exception.GlobalApplicationException;
import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;

/**
 * Clase de excepción personalizada. Necesaria para administrar
 * nuestras excepciones. Para que funcione, siempre debemos extender
 * de la clase GlobalApplicationException
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
public class ExceptionHandlerControllerEx extends GlobalApplicationException {

    public ExceptionHandlerControllerEx(String message, IGlobalErrorCodeBuilder errorCodeBuilder) {
        super(message, errorCodeBuilder);
    }
}
