package com.codexjptech.faultshieldcore.enums;

import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;

/**
 * Enumeraciones para las excepciones no marcadas de la aplicación
 * Unchecked Exceptions
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
public enum UncheckedExceptionErrorCodeEnum implements IGlobalErrorCodeBuilder {

    /*
     * ***************************** UNCHECKED EXCEPTIONS *****************************
     */
    ERROR_NULL_POINTER_EXCEPTION,
    ERROR_ARITHMETIC_EXCEPTION,
    ERROR_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION,
    ERROR_ILLEGAL_ARGUMENT_EXCEPTION,
    ERROR_CONCURRENT_MODIFICATION_EXCEPTION;

    private final String code;

    UncheckedExceptionErrorCodeEnum() {
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
