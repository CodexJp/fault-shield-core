package com.codexjptech.faultshieldcore.model;

import java.util.Arrays;
import java.util.List;

public class DataMocks {

    public static List<GlobalErrorDetailStackTrace> STACK_TRACES = Arrays.asList(
            GlobalErrorDetailStackTrace.builder()
            .fileName("ExceptionHandlerController.java")
            .methodName("ping")
            .lineNumber(42)
            .build()
    );
}
