package com.codexjptech.faultshieldcore.strategy;

import com.codexjptech.faultshieldcore.enums.HttpExceptionErrorCodeEnum;
import com.codexjptech.faultshieldcore.exception.UnauthorizedException;
import com.codexjptech.faultshieldcore.model.constant.ApplicationConstants;
import feign.Response;

/**
 * Implementación de estrategia de administración de error:
 * <br/>
 * 401 Unauthorized
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
public class UnauthorizedErrorHandlingStrategyImpl extends RestClientErrorHandlingStrategyBase{

    public UnauthorizedErrorHandlingStrategyImpl(Response response) {
        super(
                HttpExceptionErrorCodeEnum.ERROR_401_UNAUTHORIZED.getCode(),
                ApplicationConstants.CLIENT_ERROR,
                response
        );
    }

    @Override
    public Exception handle(Response response) {
        return new UnauthorizedException(
                getCode(),
                getStatus(),
                getError(),
                getMessage(),
                getPath(),
                getDetails());
    }
}
