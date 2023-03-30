package org.gopas.springbootdemo.rest.exceptionhandling;

import org.gopas.springbootdemo.exceptions.CreatePersonException;
import org.gopas.springbootdemo.exceptions.ResourceNotFoundEception;
import org.gopas.springbootdemo.exceptions.UpdatePersonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomRestExceptionHandler {

    private static final UrlPathHelper URL_PATH_HELPER = new UrlPathHelper();

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundEception.class})
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundEception exception,
                                                                    HttpServletRequest servletRequest) {
        ApiError apiError = new ApiError();
        apiError.setHttpStatus(HttpStatus.NOT_FOUND);
        apiError.setMessage(exception.getMessage());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setPath(URL_PATH_HELPER.getServletPath(servletRequest));

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({CreatePersonException.class})
    public ResponseEntity<ApiError> handleCreateException(CreatePersonException exception,
                                                          HttpServletRequest servletRequest) {

        ApiError apiError = new ApiError();
        apiError.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage(exception.getMessage());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setPath(URL_PATH_HELPER.getServletPath(servletRequest));

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UpdatePersonException.class})
    public ResponseEntity<ApiError> handleUpdateException(UpdatePersonException exception,
                                                          HttpServletRequest servletRequest) {

        ApiError apiError = new ApiError();
        apiError.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage(exception.getMessage());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setPath(URL_PATH_HELPER.getServletPath(servletRequest));

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                          HttpServletRequest servletRequest) {

        ApiError apiError = new ApiError();
        apiError.setHttpStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage("Validation error " + exception.getMessage());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setPath(URL_PATH_HELPER.getServletPath(servletRequest));

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Throwable.class})
    public ResponseEntity<ApiError> handleGeneralException(HttpServletRequest servletRequest) {
        ApiError apiError = new ApiError();
        apiError.setHttpStatus(HttpStatus.NO_CONTENT);
        apiError.setMessage("General Error ");
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setPath(URL_PATH_HELPER.getServletPath(servletRequest));

        return new ResponseEntity<>(apiError, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({HttpClientErrorException.class})
    public ResponseEntity<ApiError> handleHttpClientErrorException(HttpClientErrorException e,
                                                                   HttpServletRequest servletRequest) {
        ApiError apiError = new ApiError();
        apiError.setHttpStatus(HttpStatus.FORBIDDEN);
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setMessage(e.getMessage());
        apiError.setPath(servletRequest.getServletPath());

        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }
}
