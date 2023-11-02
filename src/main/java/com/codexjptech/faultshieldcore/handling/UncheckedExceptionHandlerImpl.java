package com.codexjptech.faultshieldcore.handling;

import com.codexjptech.faultshieldcore.exception.GlobalApplicationException;
import com.codexjptech.faultshieldcore.model.constant.GlobalErrorConstants;

/**
 * Handler para excepciones no marcadas de aplicación en tiempo de ejecución
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
public class UncheckedExceptionHandlerImpl extends CustomExceptionHandlerUtil implements ICustomExceptionHandler{

    @Override
    public void handle(Throwable exception) {

        originalException = exception;

        if(exception instanceof NullPointerException) {
            globalApplicationException =
                    new GlobalApplicationException(
                            GlobalErrorConstants.NULL_POINTER_ERROR_MESSAGE,
                            globalErrorCodeBuilder
                    );

        } else {
            String errorMessage = exception.getMessage() != null ?
                    exception.getMessage() :
                    GlobalErrorConstants.GENERIC_ERROR_MESSAGE;

            globalApplicationException =
                    new GlobalApplicationException(
                            errorMessage, globalErrorCodeBuilder
                    );

        }

        globalApplicationException.setStackTrace(exception.getStackTrace());
        manageException();
    }

    private void manageException(){
        initErrorValues(globalApplicationException);
        manageGlobalErrorDetail();
        buildResponseBody();
    }
}
