package com.codexjptech.faultshieldcore.model.constant;

import lombok.extern.slf4j.Slf4j;

/**
 * ErrorDetailConstants
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
public class ErrorDetailConstants {

    protected ErrorDetailConstants(){
        log.error("Utility Class");
    }

    // NoSuchMethodError
    public static final String NO_SUCH_METHOD_ERROR_DESCRIPTION_MESSAGE =
            "Se produjo un error al intentar acceder a un método que no existe.";

    public static final String NO_SUCH_METHOD_ERROR_SUGGESTION_MESSAGE =
            "Verifica si el método existe y es compatible. Actualiza el código y bibliotecas para coincidir.";

    // OutOfMemoryError
    public static final String OUT_OF_MEMORY_ERROR_DESCRIPTION_MESSAGE =
            "Se agotó la memoria disponible.";

    public static final String OUT_OF_MEMORY_ERROR_SUGGESTION_MESSAGE =
            "Aumenta la memoria disponible o revisa la gestión de la memoria en la aplicación.";

    // StackOverflowError
    public static final String STACK_OVERFLOW_ERROR_DESCRIPTION_MESSAGE =
            "Se produjo un desbordamiento de la pila.";

    public static final String STACK_OVERFLOW_ERROR_SUGGESTION_MESSAGE =
            "Revise y ajuste la recursión en la aplicación.";

    // VirtualMachineError
    public static final String VIRTUAL_MACHINE_ERROR_DESCRIPTION_MESSAGE =
            "Ocurrió un error de la máquina virtual.";

    public static final String VIRTUAL_MACHINE_ERROR_SUGGESTION_MESSAGE =
            "Consulta la documentación de la máquina virtual y ajusta la configuración según sea necesario.";

    // AssertionError
    public static final String ASSERTION_ERROR_DESCRIPTION_MESSAGE =
            "Una aserción falló.";

    public static final String ASSERTION_ERROR_SUGGESTION_MESSAGE =
            "Verifica las aserciones en el código y corrige los problemas identificados.";

    // NoClassDefFoundError
    public static final String NO_CLASS_DEF_FOUND_ERROR_DESCRIPTION_MESSAGE =
            "No se encontró la definición de una clase.";

    public static final String NO_CLASS_DEF_FOUND_ERROR_SUGGESTION_MESSAGE =
            "Asegúrate de que la clase esté en el classpath y que se pueda cargar correctamente.";

    // LinkageError
    public static final String LINKAGE_ERROR_DESCRIPTION_MESSAGE =
            "Ocurrió un error de vinculación de clases.";

    public static final String LINKAGE_ERROR_SUGGESTION_MESSAGE =
            "Revise la consistencia y compatibilidad de las dependencias y versiones de las clases utilizadas";

    // ExceptionInInitializerError
    public static final String EXCEPTION_IN_INITIALIZER_ERROR_DESCRIPTION_MESSAGE =
            "Error en la inicialización de una clase.";

    public static final String EXCEPTION_IN_INITIALIZER_ERROR_SUGGESTION_MESSAGE =
            "Revise el código dentro del bloque estático.";
}
