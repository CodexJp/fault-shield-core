package com.codexjptech.faultshieldcore.interceptor;

import com.codexjptech.faultshieldcore.model.GlobalResponse;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CheckedExceptionInterceptorTest {

    private static CheckedExceptionInterceptor checkedExceptionInterceptor;
    private static GlobalErrorMappers errorMappers;

    @BeforeAll
    static void setup(){
        checkedExceptionInterceptor = new CheckedExceptionInterceptor();
        errorMappers = mock(GlobalErrorMappers.class);
        checkedExceptionInterceptor.setGlobalErrorMappers(errorMappers);
    }

    @Test
    void IOExceptionInterceptorTest(){

        // *** GIVEN ***
        IOException exception = new IOException(
                "This is a IO Exception"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                checkedExceptionInterceptor.handleIOException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());

        assert globalResponse != null;
        assertEquals(globalResponse.getMessage(), exception.getMessage());
    }

    @Test
    void SQLExceptionInterceptorTest(){

        // *** GIVEN ***
        SQLException exception = new SQLException(
                "This is a SQL Exception"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                checkedExceptionInterceptor.handleSQLException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());

        assert globalResponse != null;
        assertEquals(globalResponse.getMessage(), exception.getMessage());
    }

    @Test
    void classNotFoundExceptionInterceptorTest(){

        // *** GIVEN ***
        ClassNotFoundException exception = new ClassNotFoundException(
                "This is a Class Not Found Exception"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                checkedExceptionInterceptor.handleClassNotFoundException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());

        assert globalResponse != null;
        assertEquals(globalResponse.getMessage(), exception.getMessage());
    }

    @Test
    void instantiationExceptionInterceptorTest(){

        // *** GIVEN ***
        InstantiationException exception = new InstantiationException(
                "This is a Instantiation Exception"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                checkedExceptionInterceptor.handleClassInstantiationException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());

        assert globalResponse != null;
        assertEquals(globalResponse.getMessage(), exception.getMessage());
    }

    @Test
    void methodArgumentNotValidExceptionInterceptorTest(){

        // *** GIVEN ***
        List<ObjectError> errors = List.of(
                new FieldError(
                        "ApplicationMetricRequestDTO",
                        "applicationUrl",
                        "applicationUrl: Field entity cannot be empty."
                )
        );

        BindingResult bindingResult = new BeanPropertyBindingResult(
                errors,
                "ApplicationMetricRequestDTO"
        );

        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(
                mock(MethodParameter.class),
                bindingResult
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                checkedExceptionInterceptor.handleMethodArgumentNotValid(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        assert globalResponse != null;
        assertEquals(MethodArgumentNotValidException.class, exception.getClass());
    }

    @Test
    void undeclaredThrowableExceptionInterceptorTest(){

        // *** GIVEN ***
        UndeclaredThrowableException exception = new UndeclaredThrowableException(
                new Throwable("This is a Undeclared Throwable Exception")
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                checkedExceptionInterceptor.handleUndeclaredThrowableException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());

        assert globalResponse != null;
        assertEquals(
                Integer.parseInt(globalResponse.getStatus()),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }

    @Test
    void connectExceptionInterceptorTest(){

        // *** GIVEN ***
        ConnectException exception = new ConnectException(
                "This is a Connect Exception"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                checkedExceptionInterceptor.handleConnectException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        verify(errorMappers, atLeast(1))
                .toGlobalErrorDetailStackTraceList(any(), any());

        assert globalResponse != null;
        assertEquals(globalResponse.getMessage(), exception.getMessage());
    }
}