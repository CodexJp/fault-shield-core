package com.codexjptech.faultshieldcore.interceptor;

import com.codexjptech.faultshieldcore.enums.ErrorExceptionCodeEnum;
import com.codexjptech.faultshieldcore.handling.ErrorHandlerImpl;
import com.codexjptech.faultshieldcore.model.constant.ErrorDetailConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Class used for intercept Errors Exceptions
 * <br/><br/>
 * <b>Error Exceptions Java:</b>
 * <br/><br/>
 * <table>
 *   <tr>
 *     <th>Error Class</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td>NoSuchMethodError</td>
 *     <td>This exception is raised when a method cannot be found.</td>
 *   </tr>
 *   <tr>
 *     <td>OutOfMemoryError</td>
 *     <td>This error is raised when the JVM runs out of memory.</td>
 *   </tr>
 *   <tr>
 *     <td>StackOverflowError</td>
 *     <td>This error is raised when a stack overflow occurs.</td>
 *   </tr>
 *   <tr>
 *     <td>VirtualMachineError</td>
 *     <td>This is the superclass of all errors that occur in the JVM.</td>
 *   </tr>
 *   <tr>
 *     <td>AssertionError</td>
 *     <td>This error is raised when an assertion fails.</td>
 *   </tr>
 *   <tr>
 *     <td>NoClassDefFoundError</td>
 *     <td>This error is raised when a class cannot be found.</td>
 *   </tr>
 *   <tr>
 *     <td>LinkageError</td>
 *     <td>This error is raised when a linkage problem occurs.</td>
 *   </tr>
 *   <tr>
 *     <td>ExceptionInInitializerError:</td>
 *     <td>Raised when an exception occurs in the static initializer of a class.</td>
 *   </tr>
 * </table>
 *
 * <br/>
 * @author  Jairo Polo
 * @since 0.0.1
 */
@ControllerAdvice
public class ErrorExceptionInterceptor extends ErrorHandlerImpl {

    /**
     * NoSuchMethodError
     */
    @ExceptionHandler(NoSuchMethodError.class)
    public ResponseEntity<Object> handleNoSuchMethodError(
            NoSuchMethodError exception
    ) {

        errorDetailDescription = ErrorDetailConstants.NO_SUCH_METHOD_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = ErrorDetailConstants.NO_SUCH_METHOD_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = ErrorExceptionCodeEnum.ERROR_NO_SUCH_METHOD;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * OutOfMemoryError
     */
    @ExceptionHandler(OutOfMemoryError.class)
    public ResponseEntity<Object> handleOutOfMemoryError(
            OutOfMemoryError exception
    ) {

        errorDetailDescription = ErrorDetailConstants.OUT_OF_MEMORY_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = ErrorDetailConstants.OUT_OF_MEMORY_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = ErrorExceptionCodeEnum.ERROR_OUT_OF_MEMORY;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * StackOverflowError
     */
    @ExceptionHandler(StackOverflowError.class)
    public ResponseEntity<Object> handleStackOverflowError(
            StackOverflowError exception
    ) {

        errorDetailDescription = ErrorDetailConstants.STACK_OVERFLOW_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = ErrorDetailConstants.STACK_OVERFLOW_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = ErrorExceptionCodeEnum.ERROR_STACK_OVERFLOW;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * VirtualMachineError
     */
    @ExceptionHandler(VirtualMachineError.class)
    public ResponseEntity<Object> handleVirtualMachineError(
            VirtualMachineError exception
    ) {

        errorDetailDescription = ErrorDetailConstants.VIRTUAL_MACHINE_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = ErrorDetailConstants.VIRTUAL_MACHINE_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = ErrorExceptionCodeEnum.ERROR_VIRTUAL_MACHINE;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * AssertionError
     */
    @ExceptionHandler(AssertionError.class)
    public ResponseEntity<Object> handleAssertionError(
            AssertionError exception
    ) {

        errorDetailDescription = ErrorDetailConstants.ASSERTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = ErrorDetailConstants.ASSERTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = ErrorExceptionCodeEnum.ERROR_ASSERTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * NoClassDefFoundError
     */
    @ExceptionHandler(NoClassDefFoundError.class)
    public ResponseEntity<Object> handleNoClassDefFoundError(
            NoClassDefFoundError exception
    ) {

        errorDetailDescription = ErrorDetailConstants.NO_CLASS_DEF_FOUND_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = ErrorDetailConstants.NO_CLASS_DEF_FOUND_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = ErrorExceptionCodeEnum.ERROR_NO_CLASS_DEF_FOUND;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * LinkageError
     */
    @ExceptionHandler(LinkageError.class)
    public ResponseEntity<Object> handleLinkageError(
            LinkageError exception
    ) {

        errorDetailDescription = ErrorDetailConstants.LINKAGE_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = ErrorDetailConstants.LINKAGE_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = ErrorExceptionCodeEnum.ERROR_LINKAGE;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * ExceptionInInitializerError
     */
    @ExceptionHandler(ExceptionInInitializerError.class)
    public ResponseEntity<Object> handleExceptionInInitializerError(
            ExceptionInInitializerError exception
    ) {

        errorDetailDescription = ErrorDetailConstants.EXCEPTION_IN_INITIALIZER_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = ErrorDetailConstants.EXCEPTION_IN_INITIALIZER_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = ErrorExceptionCodeEnum.ERROR_EXCEPTION_IN_INITIALIZER;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }
}
