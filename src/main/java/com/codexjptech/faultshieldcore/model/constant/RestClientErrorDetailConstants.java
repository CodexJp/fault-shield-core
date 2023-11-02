package com.codexjptech.faultshieldcore.model.constant;

import lombok.extern.slf4j.Slf4j;

/**
 * RestClientErrorDetailConstants
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
public class RestClientErrorDetailConstants {

    protected RestClientErrorDetailConstants(){
        log.error("Utility Class");
    }

    // 400 Bad Request
    public static final String BAD_REQUEST_ERROR_DESCRIPTION_MESSAGE =
            "La solicitud no pudo ser procesada debido a una solicitud incorrecta por parte del cliente.";

    public static final String BAD_REQUEST_ERROR_SUGGESTION_MESSAGE =
            "Verifica que los datos de la solicitud sean válidos y cumplan con los requisitos del servidor.";

    // 401 Unauthorized
    public static final String UNAUTHORIZED_ERROR_DESCRIPTION_MESSAGE =
            "La solicitud no pudo ser procesada porque el cliente no está autorizado para acceder a este recurso.";

    public static final String UNAUTHORIZED_ERROR_SUGGESTION_MESSAGE =
            "Asegúrate de que estés autenticado y tengas los permisos necesarios para acceder a este recurso.";

    // 403 Forbidden
    public static final String FORBIDDEN_ERROR_DESCRIPTION_MESSAGE =
            "No tienes permisos para acceder al recurso solicitado.";

    public static final String FORBIDDEN_ERROR_SUGGESTION_MESSAGE =
            "Ponte en contacto con el administrador del sistema para obtener acceso.";

    // 404 Not Found
    public static final String NOT_FOUND_ERROR_DESCRIPTION_MESSAGE =
            "El recurso solicitado no se encuentra en el servidor.";

    public static final String NOT_FOUND_ERROR_SUGGESTION_MESSAGE =
            "Verifica la URL y asegúrate de que el recurso exista.";

    // 412 Precondition Failed
    public static final String PRECONDITION_FAILED_ERROR_DESCRIPTION_MESSAGE =
            "La solicitud no se pudo procesar porque una condición previa no se cumplió.";

    public static final String PRECONDITION_FAILED_ERROR_SUGGESTION_MESSAGE =
            "Verifica las condiciones previas de la solicitud y ajústalas según sea necesario.";

    // 500 Internal Server Error
    public static final String INTERNAL_SERVER_ERROR_DESCRIPTION_MESSAGE =
            "Ocurrió un error interno en el servidor.";

    public static final String INTERNAL_SERVER_ERROR_SUGGESTION_MESSAGE =
            "Inténtalo nuevamente más tarde o ponte en contacto con el soporte técnico.";

    // 503 Service Unavailable
    public static final String SERVICE_UNAVAILABLE_ERROR_DESCRIPTION_MESSAGE =
            "El servicio no está disponible en este momento.";

    public static final String SERVICE_UNAVAILABLE_ERROR_SUGGESTION_MESSAGE =
            "Por favor, inténtalo nuevamente más tarde. Si el problema persiste, " +
            "ponte en contacto con el soporte técnico.";
}