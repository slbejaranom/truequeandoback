package ingsoft.truequeandoback.controller;

import com.sun.jdi.request.DuplicateRequestException;
import ingsoft.truequeandoback.controller.dto.ErrorDto;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestControllerAdvice
public class TruequeandoControllerAdvice {

    @ExceptionHandler(DuplicateRequestException.class)
    public ErrorDto handleDuplicateRequestException(DuplicateRequestException duplicateRequestException){
        return new ErrorDto(duplicateRequestException.getMessage(),new Date().getTime());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorDto handleIllegalAccessException(IllegalArgumentException illegalArgumentException){
        return new ErrorDto(illegalArgumentException.getMessage(),new Date().getTime());
    }
}
