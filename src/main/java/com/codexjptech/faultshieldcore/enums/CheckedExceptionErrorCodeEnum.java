package com.codexjptech.faultshieldcore.enums;

import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;

/**
 * Enumeraciones para las excepciones marcadas de la aplicación
 * Checked Exceptions
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
public enum CheckedExceptionErrorCodeEnum implements IGlobalErrorCodeBuilder {

    /*
     * ****************************** CHECKED EXCEPTIONS ******************************
     */
    ERROR_IO_EXCEPTION,
    ERROR_SQL_EXCEPTION,
    ERROR_CLASS_NOT_FOUND_EXCEPTION,
    ERROR_INSTANTIATION_EXCEPTION,
    ERROR_METHOD_ARGUMENT_NOT_VALID_EXCEPTION,
    ERROR_UNDECLARED_THROWABLE_EXCEPTION,
    ERROR_CONNECTION_EXCEPTION;

    private final String code;

    CheckedExceptionErrorCodeEnum() {
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
