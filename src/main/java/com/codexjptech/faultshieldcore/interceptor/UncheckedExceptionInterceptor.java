package com.codexjptech.faultshieldcore.interceptor;

import com.codexjptech.faultshieldcore.enums.UncheckedExceptionErrorCodeEnum;
import com.codexjptech.faultshieldcore.handling.UncheckedExceptionHandlerImpl;
import com.codexjptech.faultshieldcore.model.constant.UncheckedExceptionDetailConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ConcurrentModificationException;

/**
 * Class used for intercept Unchecked Exceptions
 * <br/><br/>
 * <b>Unchecked exceptions Java:<b/>
 * <br/><br/>
 * <table>
 *   <tr>
 *     <th>Exception Class</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td>NullPointerException</td>
 *     <td>This exception is raised when a null value is used where an object is required.</td>
 *   </tr>
 *   <tr>
 *     <td>ArithmeticException</td>
 *     <td>This exception is raised when an arithmetic operation fails.</td>
 *   </tr>
 *   <tr>
 *     <td>ArrayIndexOutOfBoundsException</td>
 *     <td>This exception is raised when an array index is out of bounds.</td>
 *   </tr>
 *   <tr>
 *     <td>IllegalArgumentException</td>
 *     <td>This exception is raised when an illegal argument is used.</td>
 *   </tr>
 *   <tr>
 *     <td>IllegalStateException</td>
 *     <td>This exception is raised when an illegal state is detected.</td>
 *   </tr>
 *   <tr>
 *     <td>ConcurrentModificationException</td>
 *     <td>This exception is raised when a collection is modified while it is being iterated over.</td>
 *   </tr>
 * </table>
 * <br/>
 * @author  Jairo Polo
 * @since 0.0.1
 */
@Slf4j
@ControllerAdvice
public class UncheckedExceptionInterceptor extends UncheckedExceptionHandlerImpl {

    /*
     * NullPointerException
     */
    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<Object> handleNullPointerException(
            NullPointerException exception
    ){

        errorDetailDescription = UncheckedExceptionDetailConstants.NULL_POINTER_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = UncheckedExceptionDetailConstants.NULL_POINTER_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = UncheckedExceptionErrorCodeEnum.ERROR_NULL_POINTER_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /*
     * ArithmeticException
     */
    @ExceptionHandler(ArithmeticException.class)
    protected ResponseEntity<Object> handleArithmeticException(
            ArithmeticException exception
    ){

        errorDetailDescription = UncheckedExceptionDetailConstants.ARITHMETIC_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = UncheckedExceptionDetailConstants.ARITHMETIC_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = UncheckedExceptionErrorCodeEnum.ERROR_ARITHMETIC_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /*
     * ArrayIndexOutOfBoundsException
     */
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    protected ResponseEntity<Object> handleArrayIndexOutOfBoundsException(
            ArrayIndexOutOfBoundsException exception
    ){

        errorDetailDescription = UncheckedExceptionDetailConstants.ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = UncheckedExceptionDetailConstants.ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = UncheckedExceptionErrorCodeEnum.ERROR_ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /*
     * IllegalArgumentException
     */
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegalArgumentException(
            IllegalArgumentException exception
    ){

        errorDetailDescription = UncheckedExceptionDetailConstants.ILLEGAL_ARGUMENT_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = UncheckedExceptionDetailConstants.ILLEGAL_ARGUMENT_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = UncheckedExceptionErrorCodeEnum.ERROR_ILLEGAL_ARGUMENT_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /*
     * ConcurrentModificationException
     */
    @ExceptionHandler(ConcurrentModificationException.class)
    protected ResponseEntity<Object> handleConcurrentModificationException(
            ConcurrentModificationException exception
    ){

        errorDetailDescription = UncheckedExceptionDetailConstants.CONCURRENT_MODIFICATION_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = UncheckedExceptionDetailConstants.CONCURRENT_MODIFICATION_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = UncheckedExceptionErrorCodeEnum.ERROR_CONCURRENT_MODIFICATION_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /*
     * ConverterNotFoundException
     */
    @ExceptionHandler(ConverterNotFoundException.class)
    protected ResponseEntity<Object> handleConverterNotFoundException(
            ConverterNotFoundException exception
    ){

        errorDetailDescription = UncheckedExceptionDetailConstants.CONVERTER_NOT_FOUND_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = UncheckedExceptionDetailConstants.CONVERTER_NOT_FOUND_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = UncheckedExceptionErrorCodeEnum.ERROR_CONVERTER_NOT_FOUND_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /*
     * IllegalStateException
     */
    @ExceptionHandler(IllegalStateException.class)
    protected ResponseEntity<Object> handleIllegalStateException(
            IllegalStateException exception
    ){

        errorDetailDescription = UncheckedExceptionDetailConstants.ILLEGAL_STATE_EXCEPTION_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = UncheckedExceptionDetailConstants.ILLEGAL_STATE_EXCEPTION_ERROR_SUGGESTION_MESSAGE;
        globalErrorCodeBuilder = UncheckedExceptionErrorCodeEnum.ERROR_CONVERTER_NOT_FOUND_EXCEPTION;

        handle(exception);

        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

}
