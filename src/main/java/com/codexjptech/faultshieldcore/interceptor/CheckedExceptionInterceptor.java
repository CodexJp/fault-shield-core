package com.codexjptech.faultshieldcore.interceptor;

import com.codexjptech.faultshieldcore.enums.CheckedExceptionErrorCodeEnum;
import com.codexjptech.faultshieldcore.handling.CheckedExceptionHandlerImpl;
import com.codexjptech.faultshieldcore.model.constant.CheckedExceptionDetailConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.ConnectException;
import java.sql.SQLException;

/**
 * Class used for intercept Checked Exceptions
 * <br/><br/>
 * <b>Checked Exceptions Java:</b>
 * <br/><br/>
 * <table>
 *   <tr>
 *     <th>Exception Class</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td>IOException</td>
 *     <td>This exception is raised when an input/output operation fails.</td>
 *   </tr>
 *   <tr>
 *     <td>SQLException</td>
 *     <td>This exception is raised when a database operation fails.</td>
 *   </tr>
 *   <tr>
 *     <td>ClassNotFoundException</td>
 *     <td>This exception is raised when a class cannot be found.</td>
 *   </tr>
 *   <tr>
 *     <td>InstantiationException</td>
 *     <td>This exception is raised when an object cannot be instantiated.</td>
 *   </tr>
 *   <tr>
 *     <td>MethodArgumentNotValidException</td>
 *     <td>Exception to be thrown when validation on an argument annotated with @Valid fails.</td>
 *   </tr>
 *   <tr>
 *     <td>UndeclaredThrowableException</td>
 *     <td>Is a runtime exception indicating problems in Java reflection.</td>
 *   </tr>
 *   <tr>
 *     <td>ConnectException</td>
 *     <td>An error occurred while attempting to connect a socket to a remote address.</td>
 *   </tr>
 * </table>
 *
 * <br/>
 * @author  Jairo Polo
 * @since 0.0.1
 */
@ControllerAdvice
public class CheckedExceptionInterceptor extends CheckedExceptionHandlerImpl {

    /**
     * IOException
     */
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleIOException(
            IOException exception
    ) {

        errorDetailDescription = CheckedExceptionDetailConstants.IO_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = CheckedExceptionDetailConstants.IO_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = CheckedExceptionErrorCodeEnum.ERROR_IO_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * SQLException
     */
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLException(
            SQLException exception
    ) {

        errorDetailDescription = CheckedExceptionDetailConstants.SQL_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = CheckedExceptionDetailConstants.SQL_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = CheckedExceptionErrorCodeEnum.ERROR_SQL_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * ClassNotFoundException
     */
    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<Object> handleClassNotFoundException(
            ClassNotFoundException exception
    ) {

        errorDetailDescription = CheckedExceptionDetailConstants.CLASS_NOT_FOUND_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = CheckedExceptionDetailConstants.CLASS_NOT_FOUND_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = CheckedExceptionErrorCodeEnum.ERROR_CLASS_NOT_FOUND_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * InstantiationException
     */
    @ExceptionHandler(InstantiationException.class)
    public ResponseEntity<Object> handleClassInstantiationException(
            InstantiationException exception
    ) {

        errorDetailDescription = CheckedExceptionDetailConstants.INSTANTIATION_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = CheckedExceptionDetailConstants.INSTANTIATION_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = CheckedExceptionErrorCodeEnum.ERROR_INSTANTIATION_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * MethodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception
    ) {

        errorDetailDescription = CheckedExceptionDetailConstants.METHOD_ARGUMENT_NOT_VALID_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = CheckedExceptionDetailConstants.METHOD_ARGUMENT_NOT_VALID_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = CheckedExceptionErrorCodeEnum.ERROR_METHOD_ARGUMENT_NOT_VALID_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }

    /**
     * UndeclaredThrowableException
     */
    @ExceptionHandler(UndeclaredThrowableException.class)
    public ResponseEntity<Object> handleUndeclaredThrowableException(
            UndeclaredThrowableException exception
    ) {

        errorDetailDescription = CheckedExceptionDetailConstants.UNDECLARED_THROWABLE_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = CheckedExceptionDetailConstants.UNDECLARED_THROWABLE_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = CheckedExceptionErrorCodeEnum.ERROR_UNDECLARED_THROWABLE_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /**
     * ConnectException
     */
    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<Object> handleConnectException(
            ConnectException exception
    ) {

        errorDetailDescription = CheckedExceptionDetailConstants.CONNECT_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = CheckedExceptionDetailConstants.CONNECT_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = CheckedExceptionErrorCodeEnum.ERROR_CONNECTION_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }
}
