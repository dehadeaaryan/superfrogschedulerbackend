package edu.tcu.cs.superfrogschedulerbackend.system.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Result handleObjectNotFoundException(ObjectNotFoundException ex) {
        return new Result(false, StatusCode.NOT_FOUND, ex.getMessage());
    }

    /**
     * This handles invalid inputs.
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Result handleValidationException(MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        Map<String, String> map = new HashMap<>(errors.size());
        errors.forEach((error) -> {
            String key = ((FieldError) error).getField();
            String val = error.getDefaultMessage();
            map.put(key, val);
        });
        return new Result(false, StatusCode.INVALID_ARGUMENT, "Provided arguments are invalid, see data for details.", map);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Result handleNoHandlerFoundException(NoHandlerFoundException ex) {
        return new Result(false, StatusCode.NOT_FOUND, "This API endpoint was not found.", ex.getMessage());
    }

    @ExceptionHandler({HttpClientErrorException.class, HttpServerErrorException.class})
    ResponseEntity<Result> handleRestClientException(HttpStatusCodeException ex) throws JsonProcessingException {

        String exceptionMessage = ex.getMessage();

        // Replace <EOL> with actual newlines.
        exceptionMessage = exceptionMessage.replace("<EOL>", "\n");

        // Extract the JSON part from the string.
        String jsonPart = exceptionMessage.substring(exceptionMessage.indexOf("{"), exceptionMessage.lastIndexOf("}") + 1);

        // Create an ObjectMapper instance.
        ObjectMapper mapper = new ObjectMapper();

        // Parse the JSON string to a JsonNode.
        JsonNode rootNode = mapper.readTree(jsonPart);

        // Extract the message.
        String formattedExceptionMessage = rootNode.path("error").path("message").asText();

        return new ResponseEntity<>(
                new Result(false,
                        ex.getStatusCode().value(),
                        "A rest client error occurred, see data for details.",
                        formattedExceptionMessage),
                ex.getStatusCode());
    }

    /**
     * Fallback handles any unhandled exceptions.
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    Result handleOtherException(Exception ex) {
        return new Result(false, StatusCode.INTERNAL_SERVER_ERROR, "A server internal error occurred.", ex.getMessage());
    }

}