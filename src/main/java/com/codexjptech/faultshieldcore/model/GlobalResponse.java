package com.codexjptech.faultshieldcore.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * GlobalResponse
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
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GlobalResponse {

    private String code;                            // Código interno del error

    private String timestamp;                       // Fecha y hora de la incidencia

    private String status;                          // código HTTP del error

    private String error;                           // Causa del error

    private String message;                         // Mensaje de error

    private String path;                            // Ruta que se intenta acceder

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object detail;                         // Detalle de la respuesta (validaciones, metadatos, etc...)

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;                            // Dato de retorno en caso de ser necesario

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPath() {
        if (path == null || path.isEmpty()) {
            return null;
        }
        return path;
    }
}
