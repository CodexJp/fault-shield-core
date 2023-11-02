package com.codexjptech.faultshieldcore.util;

/**
 * Interfaz usada para la generación de códigos de Excepción
 * personalizados de la aplicación. Cada clase que contenga los
 * Enum que identifican a cada excepción de nuestra aplicación,
 * deberá implementar esta interfaz para la construcción inteligente
 * del código de excepción vinculado al Enum
 *
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
public interface IGlobalErrorCodeBuilder {

    GlobalErrorCodeManagerImpl ERROR_CODE_MANAGER = GlobalErrorCodeManagerImpl.getInstance();

    String getCode();

    String getEnumName();
}
