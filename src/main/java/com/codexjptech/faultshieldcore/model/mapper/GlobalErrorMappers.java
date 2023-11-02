package com.codexjptech.faultshieldcore.model.mapper;

import com.codexjptech.faultshieldcore.config.AppConfig;
import com.codexjptech.faultshieldcore.exception.GlobalApplicationException;
import com.codexjptech.faultshieldcore.exception.GlobalRestClientException;
import com.codexjptech.faultshieldcore.model.GlobalErrorDetailStackTrace;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * GlobalErrorMappers
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
@Component
public final class GlobalErrorMappers {

    private static String applicationPackage;

    @SuppressWarnings({"squid:S3010"})
    private GlobalErrorMappers(AppConfig appConfig) {
        applicationPackage = appConfig.getApplicationPackage();
    }

    public static GlobalErrorDetailStackTrace toGlobalErrorDetailStackTrace(
            StackTraceElement traceElement,
            GlobalApplicationException exception
    ){

        return Optional.ofNullable(exception)
                .map(ex -> GlobalErrorDetailStackTrace.builder()
                        .fileName(traceElement.getFileName())
                        .methodName(traceElement.getMethodName())
                        .lineNumber(traceElement.getLineNumber())
                        .build())
                .orElse(GlobalErrorDetailStackTrace.builder()  // En caso de que exception sea nulo
                        .fileName(traceElement.getFileName())
                        .methodName(traceElement.getMethodName())
                        .lineNumber(traceElement.getLineNumber())
                        .build());
    }

    public static List<GlobalErrorDetailStackTrace> toGlobalErrorDetailStackTraceList(
            StackTraceElement[] traceElements,
            GlobalApplicationException exception
    ){

        List<GlobalErrorDetailStackTrace> details = new ArrayList<>();

        Arrays.stream(traceElements)
                .filter(element -> element.getClassName().startsWith(applicationPackage))
                .distinct()
                .forEach(element -> {
                    GlobalErrorDetailStackTrace detail = toGlobalErrorDetailStackTrace(element, exception);
                    details.add(detail);
                });

        return details;
    }

    public static GlobalApplicationException toGlobalApplicationException(GlobalRestClientException exception){
        return GlobalApplicationException.builder()
                .code(exception.getCode())
                .status(exception.getStatus())
                .error(exception.getError())
                .message(exception.getMessage())
                .path(exception.getPath())
                .build();
    }
}
