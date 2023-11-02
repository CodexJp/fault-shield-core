package com.codexjptech.faultshieldcore.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * GlobalErrorDetail
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
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalErrorDetail {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String applicationName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String exceptionType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String customExceptionEnumName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String suggestions;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String trackingId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<GlobalErrorDetailStackTrace> stackTrace;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> validations;

    public String printStackTrace() {

        String headerText = "Technical Details (Stack Trace): ";
        String bodyText = stackTrace.stream()
            .flatMap(trace -> Stream.of("\n",
                    formatProperty("Tracking Id", trackingId),
                    formatProperty("Exception", exceptionType),
                    formatProperty("Custom Exception Name", customExceptionEnumName),
                    formatProperty("Class", trace.getFileName()),
                    formatProperty("Method", trace.getMethodName()),
                    formatProperty("Line", trace.getLineNumber())
                )
                .filter(property -> !property.isEmpty()))
            .collect(Collectors.joining());

        return headerText + bodyText;
    }

    public String printValidations() {

        String headerText = "Validations: ";
        String bodyText = validations.stream()
            .flatMap(validation -> Stream.of("\n",
                        formatProperty("Tracking Id", trackingId),
                        formatProperty("Exception", exceptionType),
                        formatProperty("Custom Exception Name", customExceptionEnumName),
                        formatProperty("Validation", validation)
                    )
                    .filter(property -> !property.isEmpty()))
            .collect(Collectors.joining());

        return headerText + bodyText;
    }

    private String formatProperty(String label, Object value){
        return value != null ? label + ": " + value + " | " : "";
    }
}
