package com.codexjptech.faultshieldcore.handling;

import com.codexjptech.faultshieldcore.exception.GlobalApplicationException;
import com.codexjptech.faultshieldcore.model.constant.GlobalErrorConstants;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Handler para excepciones marcadas de aplicación en tiempo de ejecución
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
public class CheckedExceptionHandlerImpl extends CustomExceptionHandlerUtil implements ICustomExceptionHandler{

    @Override
    public void handle(Throwable exception) {

        originalException = exception;

        if(exception instanceof MethodArgumentNotValidException){

            globalApplicationException =
                    new GlobalApplicationException(
                            GlobalErrorConstants.VALIDATION_FAILED_MESSAGE,
                            globalErrorCodeBuilder
                    );

            manageMethodArgumentNotValidException(exception);

        } else {
            String errorMessage = exception.getMessage() != null ?
                    exception.getMessage() :
                    GlobalErrorConstants.GENERIC_ERROR_MESSAGE;

            globalApplicationException =
                    new GlobalApplicationException(
                            errorMessage,
                            globalErrorCodeBuilder
                    );

            manageException(originalException);
        }
    }

    private void manageException(Throwable exception){

        globalApplicationException.setStackTrace(exception.getStackTrace());

        initErrorValues(globalApplicationException);
        manageGlobalErrorDetail();
        buildResponseBody();
    }

    private void manageMethodArgumentNotValidException(Throwable exception){

        globalApplicationException.setStackTrace(exception.getStackTrace());

        initErrorValues(globalApplicationException);
        manageValidationErrorResponse();
        buildMethodArgumentNotValidExceptionResponseBody();
    }
}
