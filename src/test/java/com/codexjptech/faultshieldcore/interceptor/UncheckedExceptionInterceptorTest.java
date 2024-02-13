package com.codexjptech.faultshieldcore.interceptor;

import com.codexjptech.faultshieldcore.model.GlobalErrorDetail;
import com.codexjptech.faultshieldcore.model.GlobalResponse;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ConcurrentModificationException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class UncheckedExceptionInterceptorTest {

    private static UncheckedExceptionInterceptor uncheckedExceptionInterceptor;

    @BeforeAll
    static void setup(){
        uncheckedExceptionInterceptor = new UncheckedExceptionInterceptor();
        GlobalErrorMappers errorMappers = mock(GlobalErrorMappers.class);
        uncheckedExceptionInterceptor.setGlobalErrorMappers(errorMappers);
    }

    @Test
    void nullPointerExceptionInterceptorTest(){

        // *** GIVEN ***
        NullPointerException exception = new NullPointerException(
                "This is a Null Pointer Exception"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                uncheckedExceptionInterceptor.handleNullPointerException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        assert globalResponse != null;
        GlobalErrorDetail globalErrorDetail = (GlobalErrorDetail) globalResponse.getDetail();

        // *** THEN ***
        assertEquals(globalErrorDetail.getExceptionType(), exception.getClass().getSimpleName());
    }

    @Test
    void arithmeticExceptionInterceptorTest(){

        // *** GIVEN ***
        ArithmeticException exception = new ArithmeticException(
                "This is a Arithmetic Exception"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                uncheckedExceptionInterceptor.handleArithmeticException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        assert globalResponse != null;
        GlobalErrorDetail globalErrorDetail = (GlobalErrorDetail) globalResponse.getDetail();

        // *** THEN ***
        assertEquals(globalErrorDetail.getExceptionType(), exception.getClass().getSimpleName());
    }

    @Test
    void arrayIndexOutOfBoundsExceptionInterceptorTest(){

        // *** GIVEN ***
        ArrayIndexOutOfBoundsException exception = new ArrayIndexOutOfBoundsException(
                "This is a Array Index Out Of Bounds Exception"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                uncheckedExceptionInterceptor.handleArrayIndexOutOfBoundsException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        assert globalResponse != null;
        GlobalErrorDetail globalErrorDetail = (GlobalErrorDetail) globalResponse.getDetail();

        // *** THEN ***
        assertEquals(globalErrorDetail.getExceptionType(), exception.getClass().getSimpleName());
    }

    @Test
    void illegalArgumentExceptionInterceptorTest(){

        // *** GIVEN ***
        IllegalArgumentException exception = new IllegalArgumentException(
                "This is a Illegal Argument Exception"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                uncheckedExceptionInterceptor.handleIllegalArgumentException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        assert globalResponse != null;
        GlobalErrorDetail globalErrorDetail = (GlobalErrorDetail) globalResponse.getDetail();

        // *** THEN ***
        assertEquals(globalErrorDetail.getExceptionType(), exception.getClass().getSimpleName());
    }

    @Test
    void concurrentModificationExceptionInterceptorTest(){

        // *** GIVEN ***
        ConcurrentModificationException exception = new ConcurrentModificationException(
                "This is a Concurrent Modification Exception"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                uncheckedExceptionInterceptor.handleConcurrentModificationException(exception);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        assert globalResponse != null;
        GlobalErrorDetail globalErrorDetail = (GlobalErrorDetail) globalResponse.getDetail();

        // *** THEN ***
        assertEquals(globalErrorDetail.getExceptionType(), exception.getClass().getSimpleName());
    }
}