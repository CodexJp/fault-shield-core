package com.codexjptech.faultshieldcore.enums.app;

import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;

/**
 * Implementación de la interfaz IGlobalErrorCodeBuilder. Esta concreción
 * es necesaria siempre que queramos crear enumeraciones particulares
 * para vincular a nuestras excepciones personalizadas
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
public enum ControllerErrorCodeEnum implements IGlobalErrorCodeBuilder {

    /*
     * **************************** CONTROLLER EXCEPTIONS ****************************
     */

    // ExceptionHandlerRfController
    ERROR_EXAMPLE;

    private final String code;

    ControllerErrorCodeEnum() {
        this.code = ERROR_CODE_MANAGER.generateControllerErrorCode();
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getEnumName(){
        return name();
    }

}
