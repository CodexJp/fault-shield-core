package com.codexjptech.faultshieldcore.interceptor;

import com.codexjptech.faultshieldcore.model.GlobalResponse;
import com.codexjptech.faultshieldcore.model.mapper.GlobalErrorMappers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ErrorExceptionInterceptorTest {

    private static ErrorExceptionInterceptor errorExceptionInterceptor;

    @BeforeAll
    static void setup(){
        errorExceptionInterceptor = new ErrorExceptionInterceptor();
        GlobalErrorMappers errorMappers = mock(GlobalErrorMappers.class);
        errorExceptionInterceptor.setGlobalErrorMappers(errorMappers);
    }

    @Test
    void noSuchMethodErrorTest(){

        // *** GIVEN ***
        NoSuchMethodError error = new NoSuchMethodError(
                "This is a No Such Method Error"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                errorExceptionInterceptor.handleNoSuchMethodError(error);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        assertNotNull(globalResponse);
        assertEquals(globalResponse.getMessage(), error.getMessage());
    }

    @Test
    void outOfMemoryErrorTest(){

        // *** GIVEN ***
        OutOfMemoryError error = new OutOfMemoryError(
                "This is a Out Of Memory Error"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                errorExceptionInterceptor.handleOutOfMemoryError(error);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        assertNotNull(globalResponse);
        assertEquals(globalResponse.getMessage(), error.getMessage());
    }

    @Test
    void stackOverflowErrorTest(){

        // *** GIVEN ***
        StackOverflowError error = new StackOverflowError(
                "This is a Stack Overflow Error"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                errorExceptionInterceptor.handleStackOverflowError(error);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        assertNotNull(globalResponse);
        assertEquals(globalResponse.getMessage(), error.getMessage());
    }

    @Test
    void virtualMachineErrorTest(){

        // *** GIVEN ***
        VirtualMachineError error = new VirtualMachineError() {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        };

        // *** WHEN ***
        ResponseEntity<Object> response =
                errorExceptionInterceptor.handleVirtualMachineError(error);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        assertNotNull(globalResponse);
        assertEquals(globalResponse.getMessage(), error.getMessage());
    }

    @Test
    void assertionErrorTest(){

        // *** GIVEN ***
        AssertionError error = new AssertionError(
                "This is a Assertion Error"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                errorExceptionInterceptor.handleAssertionError(error);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        assertNotNull(globalResponse);
        assertEquals(globalResponse.getMessage(), error.getMessage());
    }

    @Test
    void noClassDefFoundErrorTest(){

        // *** GIVEN ***
        NoClassDefFoundError error = new NoClassDefFoundError(
                "This is a No Class Def Found Error"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                errorExceptionInterceptor.handleNoClassDefFoundError(error);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        assertNotNull(globalResponse);
        assertEquals(globalResponse.getMessage(), error.getMessage());
    }

    @Test
    void linkageErrorTest(){

        // *** GIVEN ***
        LinkageError error = new LinkageError(
                "This is a Linkage Error"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                errorExceptionInterceptor.handleLinkageError(error);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        assertNotNull(globalResponse);
        assertEquals(globalResponse.getMessage(), error.getMessage());
    }

    @Test
    void exceptionInInitializerErrorTest(){

        // *** GIVEN ***
        ExceptionInInitializerError error = new ExceptionInInitializerError(
                "This is a Exception InInitializer Error"
        );

        // *** WHEN ***
        ResponseEntity<Object> response =
                errorExceptionInterceptor.handleExceptionInInitializerError(error);

        GlobalResponse globalResponse = (GlobalResponse) response.getBody();

        // *** THEN ***
        assertNotNull(globalResponse);
        assertEquals(globalResponse.getMessage(), error.getMessage());
    }
}