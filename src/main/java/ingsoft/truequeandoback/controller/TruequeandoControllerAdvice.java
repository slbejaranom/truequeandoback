package ingsoft.truequeandoback.controller;

import com.sun.jdi.request.DuplicateRequestException;
import ingsoft.truequeandoback.controller.dto.ErrorDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class TruequeandoControllerAdvice {

    @ExceptionHandler(DuplicateRequestException.class)
    public ErrorDto handleDuplicateRequestException(DuplicateRequestException duplicateRequestException){
        return new ErrorDto(duplicateRequestException.getMessage(),new Date().getTime());
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ErrorDto handleIllegalAccessException(IllegalAccessException illegalAccessException){
        return new ErrorDto(illegalAccessException.getMessage(),new Date().getTime());
    }
}
