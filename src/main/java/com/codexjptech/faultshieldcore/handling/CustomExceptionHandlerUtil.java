package com.codexjptech.faultshieldcore.handling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.codexjptech.faultshieldcore.enums.HttpExceptionErrorCodeEnum;
import com.codexjptech.faultshieldcore.exception.GlobalApplicationException;
import com.codexjptech.faultshieldcore.model.GlobalErrorDetail;
import com.codexjptech.faultshieldcore.model.GlobalErrorDetailStackTrace;
import com.codexjptech.faultshieldcore.model.GlobalResponse;
import com.codexjptech.faultshieldcore.model.constant.GlobalErrorConstants;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import com.codexjptech.faultshieldcore.util.IGlobalErrorCodeBuilder;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Clase utilitaria usada para gestionar los datos que conforman
 * el cuerpo del objeto de respuesta generado luego de interceptar
 * y manejar las excepciones en tiempo de ejecución en la aplicación
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
@Setter
public class CustomExceptionHandlerUtil {

    protected String errorDetailDescription;
    protected String errorDetailSuggestions;

    private String exceptionType;
    private String trackingId;

    protected Throwable originalException;
    protected ZonedDateTime timestamp;
    private StackTraceElement[] traceElements;

    protected GlobalErrorDetail errorDetail;
    protected GlobalResponse errorResponse;
    protected GlobalApplicationException globalApplicationException;
    protected IGlobalErrorCodeBuilder globalErrorCodeBuilder;
    protected ObjectMapper objectMapper;

    private List<GlobalErrorDetailStackTrace> errorDetailStackTrace;
    private List<String> validationErrorDetails;

    @Autowired
    private GlobalErrorMappers globalErrorMappers;

    protected void initErrorValues(Exception exception) {

        errorDetail = null;
        errorDetailStackTrace = null;
        validationErrorDetails = null;

        objectMapper = new ObjectMapper();
        traceElements = exception.getStackTrace();
        timestamp = ZonedDateTime.now(ZoneId.of("Z"));
        exceptionType = originalException.getClass().getSimpleName();

        buildUUID();
    }

    public void manageGlobalErrorDetail() {
        buildGlobalErrorDetailStackTrace();
        buildGlobalErrorDetail();
    }

    protected void manageValidationErrorResponse() {
        buildValidationErrorDetails();
        buildGlobalErrorDetail();
    }

    private void buildValidationErrorDetails(){

        MethodArgumentNotValidException exception =
                (MethodArgumentNotValidException) originalException;

        validationErrorDetails = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();
    }

    private void buildGlobalErrorDetailStackTrace(){
        // Stack trace
        errorDetailStackTrace =
                globalErrorMappers.toGlobalErrorDetailStackTraceList(
                        traceElements,
                        globalApplicationException
                );
    }

    @SneakyThrows
    private void buildGlobalErrorDetail(){
        errorDetail = GlobalErrorDetail.builder()
                .applicationName(IGlobalErrorCodeBuilder.ERROR_CODE_MANAGER.getApplicationName())
                .exceptionType(exceptionType)
                .customExceptionEnumName(globalApplicationException.getCustomExceptionEnumName())
                .description(errorDetailDescription)
                .suggestions(errorDetailSuggestions)
                .trackingId(trackingId)
                .stackTrace(errorDetailStackTrace)
                .validations(validationErrorDetails)
                .build();

        if(originalException instanceof MethodArgumentNotValidException){
            log.debug(errorDetail.printValidations());
        }else{
            log.debug(errorDetail.printStackTrace());
        }
    }

    @SneakyThrows
    protected void buildResponseBody() {
        errorResponse = GlobalResponse.builder()
                .code(globalApplicationException.getCode())
                .message(globalApplicationException.getMessage())
                .error(globalApplicationException.getError())
                .status(globalApplicationException.getStatus())
                .path(globalApplicationException.getPath())
                .detail(errorDetail)
                .timestamp(String.valueOf(timestamp))
                .build();

        log.error(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorResponse));
    }

    @SneakyThrows
    protected void buildMethodArgumentNotValidExceptionResponseBody() {
        errorResponse = GlobalResponse.builder()
                .code(HttpExceptionErrorCodeEnum.ERROR_400_BAD_REQUEST.getCode())
                .message(GlobalErrorConstants.VALIDATION_FAILED_MESSAGE)
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .status(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .detail(errorDetail)
                .timestamp(String.valueOf(timestamp))
                .build();

        log.error(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorResponse));
    }

    private void buildUUID(){
        UUID uuid = UUID.randomUUID();
        trackingId = uuid.toString();
    }
}
