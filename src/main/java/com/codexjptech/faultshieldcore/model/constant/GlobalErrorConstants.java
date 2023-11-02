package com.codexjptech.faultshieldcore.model.constant;

import lombok.extern.slf4j.Slf4j;

/**
 * GlobalErrorConstants
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
@Slf4j
public class GlobalErrorConstants {

    protected GlobalErrorConstants(){
        log.error("Utility Class");
    }

    public static final String GENERIC_ERROR_MESSAGE = "Se produjo una excepción sin causa definida.";
    public static final String NULL_POINTER_ERROR_MESSAGE = "Null Pointer Exception: Se intentó acceder a una referencia nula..";
    public static final String VALIDATION_FAILED_MESSAGE = "Validation failed for method argument(s)";
}
