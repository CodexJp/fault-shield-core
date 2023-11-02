package com.codexjptech.faultshieldcore.model.constant;

import lombok.extern.slf4j.Slf4j;

/**
 * UncheckedExceptionDetailConstants
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
public class UncheckedExceptionDetailConstants {

    protected UncheckedExceptionDetailConstants(){
        log.error("Utility Class");
    }

    // NullPointerException
    public static final String NULL_POINTER_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "Se intentó acceder a una referencia nula.";

    public static final String NULL_POINTER_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Asegúrate de que todas las referencias sean no nulas antes de utilizarlas.";

    // ArithmeticException
    public static final String ARITHMETIC_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "Se produjo un error aritmético.";

    public static final String ARITHMETIC_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Verifica los cálculos y asegúrate de evitar divisiones por cero.";

    // ArrayIndexOutOfBoundsException
    public static final String ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "Se intentó acceder a un índice no válido en un arreglo.";

    public static final String ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Verifica los índices de acceso a arreglos y asegúrate de que estén dentro de los límites válidos.";

    // IllegalArgumentException
    public static final String ILLEGAL_ARGUMENT_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "Se proporcionó un argumento ilegal.";

    public static final String ILLEGAL_ARGUMENT_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Asegúrate de proporcionar argumentos válidos y coherentes.";

    // IllegalStateException
    public static final String ILLEGAL_STATE_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "El estado de la aplicación no es válido para la operación actual.";

    public static final String ILLEGAL_STATE_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Verifica el estado de la aplicación y ajústalo según sea necesario.";

    // ConcurrentModificationException
    public static final String CONCURRENT_MODIFICATION_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "Se realizó una modificación concurrente en una estructura que no lo permite.";

    public static final String CONCURRENT_MODIFICATION_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Utiliza estructuras de datos apropiadas para evitar modificaciones concurrentes.";
}
