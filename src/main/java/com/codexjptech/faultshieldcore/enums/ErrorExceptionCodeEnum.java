package com.codexjptech.faultshieldcore.enums;

import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;

/**
 * Enumeraciones para los errores de aplicación
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
public enum ErrorExceptionCodeEnum implements IGlobalErrorCodeBuilder {

    /*
     * ******************************* ERROR EXCEPTIONS ********************************
     */
    ERROR_NO_SUCH_METHOD,
    ERROR_OUT_OF_MEMORY,
    ERROR_STACK_OVERFLOW,
    ERROR_VIRTUAL_MACHINE,
    ERROR_ASSERTION,
    ERROR_NO_CLASS_DEF_FOUND,
    ERROR_LINKAGE,
    ERROR_EXCEPTION_IN_INITIALIZER;

    private final String code;

    ErrorExceptionCodeEnum(){
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
