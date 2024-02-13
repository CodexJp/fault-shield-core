package com.codexjptech.faultshieldcore.controller;

import com.codexjptech.faultshieldcore.enums.app.ControllerErrorCodeEnum;
import com.codexjptech.faultshieldcore.exception.app.ExceptionHandlerControllerEx;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExceptionHandlerController.class)
@ExtendWith(MockitoExtension.class)
class ExceptionHandlerControllerTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    @Spy
    private ExceptionHandlerController exceptionHandlerController;

    @MockBean
    private GlobalErrorMappers globalErrorMappers;

    @Test
    void pingTest() throws Exception{

        // *** GIVEN ***
        ExceptionHandlerControllerEx exception = new ExceptionHandlerControllerEx(
            "This is a custom exception example",
            ControllerErrorCodeEnum.ERROR_EXAMPLE
        );

        // *** WHEN ***
        doThrow(exception).when(exceptionHandlerController).ping();

        // *** THEN ***
        mockMvc.perform(get("/ping")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isInternalServerError())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(result -> assertTrue(
                    result.getResolvedException() instanceof ExceptionHandlerControllerEx));
    }
}