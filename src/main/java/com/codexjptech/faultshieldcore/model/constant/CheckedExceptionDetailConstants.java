package com.codexjptech.faultshieldcore.model.constant;

import lombok.extern.slf4j.Slf4j;

/**
 * CheckedExceptionDetailConstants
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
public class CheckedExceptionDetailConstants {

    protected CheckedExceptionDetailConstants(){
        log.error("Utility Class");
    }

    // IOException
    public static final String IO_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "Se produjo un error de entrada/salida.";

    public static final String IO_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Verifica la conectividad con los recursos de almacenamiento y la red.";

    // SQLException
    public static final String SQL_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "Ocurrió un error al acceder a la base de datos.";

    public static final String SQL_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Verifica la configuración de la base de datos y la consulta SQL.";

    // ClassNotFoundException
    public static final String CLASS_NOT_FOUND_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "No se encontró una clase requerida.";

    public static final String CLASS_NOT_FOUND_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Asegúrate de que la clase esté en el classpath y que su nombre esté escrito correctamente.";

    // InstantiationException
    public static final String INSTANTIATION_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "No se pudo crear una instancia de una clase.";

    public static final String INSTANTIATION_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Verifica que la clase sea instanciable y que se pasen los argumentos correctos.";

    // NoSuchMethodException
    public static final String NO_SUCH_METHOD_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "No se encontró un método requerido.";

    public static final String NO_SUCH_METHOD_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Asegúrate de que el método exista y tenga la firma correcta.";

    // MethodArgumentNotValidException
    public static final String METHOD_ARGUMENT_NOT_VALID_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "Los argumentos del método no son válidos.";

    public static final String METHOD_ARGUMENT_NOT_VALID_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Verifica los argumentos proporcionados y asegúrate de que cumplan con los requisitos.";

    // UndeclaredThrowableException
    public static final String UNDECLARED_THROWABLE_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "Ocurrió una excepción no declarada.";

    public static final String UNDECLARED_THROWABLE_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Revise el código y gestione adecuadamente las excepciones no declaradas.";

    // ConnectException
    public static final String CONNECT_EXCEPTION_ERROR_DESCRIPTION_MESSAGE =
            "Ocurrió un error de conexión.";

    public static final String CONNECT_EXCEPTION_ERROR_SUGGESTION_MESSAGE =
            "Revise su configuración de red para asegurarse de que el recurso esté disponible y funcionando. " +
            "Verifique autenticación y posibles restricciones del firewall.";
}
