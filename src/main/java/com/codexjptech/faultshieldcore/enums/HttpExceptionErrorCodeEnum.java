package com.codexjptech.faultshieldcore.enums;

import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;

/**
 * Enumeraciones para los errores de tipo HTTP de la aplicación
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
public enum HttpExceptionErrorCodeEnum implements IGlobalErrorCodeBuilder {

    /*
     * ******************************* HTTP EXCEPTIONS ********************************
     */
    ERROR_400_BAD_REQUEST,
    ERROR_401_UNAUTHORIZED,
    ERROR_403_FORBIDDEN,
    ERROR_404_NOT_FOUND,
    ERROR_412_PRECONDITION_FAILED,
    ERROR_500_INTERNAL_SERVER_ERROR,
    ERROR_503_SERVICE_UNAVAILABLE;

    private final String code;

    HttpExceptionErrorCodeEnum() {
        this.code = ERROR_CODE_MANAGER.generateGlobalErrorCode();
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
