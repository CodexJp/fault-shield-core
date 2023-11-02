package com.codexjptech.faultshieldcore.interceptor;

import com.codexjptech.faultshieldcore.exception.BadRequestException;
import com.codexjptech.faultshieldcore.exception.ForbiddenException;
import com.codexjptech.faultshieldcore.exception.InternalServerErrorException;
import com.codexjptech.faultshieldcore.exception.NotFoundException;
import com.codexjptech.faultshieldcore.exception.PreconditionFailedException;
import com.codexjptech.faultshieldcore.exception.ServiceUnavailableException;
import com.codexjptech.faultshieldcore.exception.UnauthorizedException;
import com.codexjptech.faultshieldcore.handling.RestClientExceptionHandlerImpl;
import com.codexjptech.faultshieldcore.model.constant.RestClientErrorDetailConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Class used for intercept HTTP Exceptions
 * <br/><br/>
 * <b>HTTP Java Responses:</b>
 * <br/><br/>
 * <table>
 *   <tr>
 *     <th>HTTP Code</th>
 *     <th>Message</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td>400</td>
 *     <td>Bad Request</td>
 *     <td>Client sent an invalid request, such as lacking required request body or parameter.</td>
 *   </tr>
 *   <tr>
 *     <td>401</td>
 *     <td>Unauthorized</td>
 *     <td>Client failed to authenticate with the server.</td>
 *   </tr>
 *   <tr>
 *     <td>403</td>
 *     <td>Forbidden</td>
 *     <td>Client authenticated but does not have permission to access the requested resource.</td>
 *   </tr>
 *   <tr>
 *     <td>404</td>
 *     <td>Not Found</td>
 *     <td>The requested resource does not exist.</td>
 *   </tr>
 *   <tr>
 *     <td>412</td>
 *     <td>Precondition Failed</td>
 *     <td>One or more conditions in the request header fields evaluated to false.</td>
 *   </tr>
 *   <tr>
 *     <td>500</td>
 *     <td>Internal Server Error</td>
 *     <td>A generic error occurred on the server.</td>
 *   </tr>
 *   <tr>
 *     <td>503</td>
 *     <td>Service Unavailable</td>
 *     <td>The requested service is not available.</td>
 *   </tr>
 * </table>
 * <br/>
 * @author  Jairo Polo
 * @since 0.0.1
 */
@Slf4j
@ControllerAdvice
public class RestClientExceptionInterceptor extends RestClientExceptionHandlerImpl {

    // ********************** HTTP REST CLIENT EXCEPTIONS **********************

    /*
     * 400 Bad Request
     */
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException (
            BadRequestException exception
    ) {

        errorDetailDescription = RestClientErrorDetailConstants.BAD_REQUEST_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = RestClientErrorDetailConstants.BAD_REQUEST_ERROR_SUGGESTION_MESSAGE;

        handle(exception);

        // Retornamos código de estado HTTP personalizado
        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }

    /*
     * 401 Unauthorized
     */
    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<Object> handleUnauthorizedException (
            UnauthorizedException exception
    ) {

        errorDetailDescription = RestClientErrorDetailConstants.UNAUTHORIZED_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = RestClientErrorDetailConstants.UNAUTHORIZED_ERROR_SUGGESTION_MESSAGE;

        handle(exception);

        // Retornamos código de estado HTTP personalizado
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(errorResponse);
    }

    /*
     * 403 Forbidden
     */
    @ExceptionHandler(ForbiddenException.class)
    protected ResponseEntity<Object> handleForbiddenException (
            ForbiddenException exception
    ) {

        errorDetailDescription = RestClientErrorDetailConstants.FORBIDDEN_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = RestClientErrorDetailConstants.FORBIDDEN_ERROR_SUGGESTION_MESSAGE;

        handle(exception);

        // Retornamos código de estado HTTP personalizado
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(errorResponse);
    }

    /*
     * 404 Not Found
     */
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException (
            NotFoundException exception
    ) {

        errorDetailDescription = RestClientErrorDetailConstants.NOT_FOUND_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = RestClientErrorDetailConstants.NOT_FOUND_ERROR_SUGGESTION_MESSAGE;

        handle(exception);

        // Retornamos código de estado HTTP personalizado
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    /*
     * 412 Precondition failed
     */
    @ExceptionHandler(PreconditionFailedException.class)
    protected ResponseEntity<Object> handlePreconditionFailedException (
            PreconditionFailedException exception
    ) {

        errorDetailDescription = RestClientErrorDetailConstants.PRECONDITION_FAILED_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = RestClientErrorDetailConstants.PRECONDITION_FAILED_ERROR_SUGGESTION_MESSAGE;

        handle(exception);

        // Retornamos código de estado HTTP personalizado
        return ResponseEntity
                .status(HttpStatus.PRECONDITION_FAILED)
                .body(errorResponse);
    }

    /*
     * 500 Internal Server Error
     */
    @ExceptionHandler(InternalServerErrorException.class)
    protected ResponseEntity<Object> handleInternalServerErrorException(
            InternalServerErrorException exception
    ) {

        errorDetailDescription = RestClientErrorDetailConstants.INTERNAL_SERVER_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = RestClientErrorDetailConstants.INTERNAL_SERVER_ERROR_SUGGESTION_MESSAGE;

        handle(exception);

        // Retornamos código de estado HTTP personalizado
        return ResponseEntity
                .internalServerError()
                .body(errorResponse);
    }

    /*
     * 503 Service Unavailable
     */
    @ExceptionHandler(ServiceUnavailableException.class)
    protected ResponseEntity<Object> handleServiceUnavailableException(
            ServiceUnavailableException exception
    ) {

        errorDetailDescription = RestClientErrorDetailConstants.SERVICE_UNAVAILABLE_ERROR_DESCRIPTION_MESSAGE;
        errorDetailSuggestions = RestClientErrorDetailConstants.SERVICE_UNAVAILABLE_ERROR_SUGGESTION_MESSAGE;

        handle(exception);

        // Retornamos código de estado HTTP personalizado
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(errorResponse);
    }

}
