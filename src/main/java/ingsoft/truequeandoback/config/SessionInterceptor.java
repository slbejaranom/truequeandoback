package ingsoft.truequeandoback.config;

import static ingsoft.truequeandoback.utils.Constants.PATRON_REGEX_TOKEN;
import static ingsoft.truequeandoback.utils.Constants.RUTAS_ACCESIBLES_CLIENTE;
import static ingsoft.truequeandoback.utils.Constants.RUTAS_ACCESIBLES_TODOS;

import com.fasterxml.jackson.databind.ObjectMapper;
import ingsoft.truequeandoback.controller.dto.ErrorDto;
import ingsoft.truequeandoback.domain.ServicioAutenticacion;
import ingsoft.truequeandoback.domain.TokenDTO;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class SessionInterceptor implements HandlerInterceptor {

  @Autowired
  ServicioAutenticacion servicioAutenticacion;

  @Autowired
  ObjectMapper objectMapper;

  @Override
  public boolean preHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler) throws Exception {
    // your code
    String ruta = request.getRequestURI();
    String authHeader = request.getHeader("Authorization");
    log.info("Intento de acceso a aplicacion en ruta {} con auth header {}", ruta, authHeader);
    if(request.getMethod().equals("OPTIONS")){
      return true;
    }
    if (authHeader == null && !RUTAS_ACCESIBLES_TODOS.contains(ruta)) {
      generarError(response, HttpStatus.FORBIDDEN);
      return false;
    }
    if(RUTAS_ACCESIBLES_TODOS.contains(ruta)){
      return true;
    }
    String[] authArgs = authHeader.split(" ");
    if(authArgs.length < 2){
      generarError(response,HttpStatus.BAD_REQUEST);
      return false;
    }
    TokenDTO tokenAVerificar = new TokenDTO();
    tokenAVerificar.setValorToken(authArgs[1]);
    if(!servicioAutenticacion.verificarTokenActivo(tokenAVerificar)){
      generarError(response,HttpStatus.FORBIDDEN);
      return false;
    }
    String token = new String(Base64.getDecoder().decode(authArgs[1]), StandardCharsets.UTF_8);
    if (!PATRON_REGEX_TOKEN.matcher(token).matches()) {
      return false;
    }
    if(!servicioAutenticacion.verificarAccesoPorRol(token, ruta)){
      generarError(response,HttpStatus.FORBIDDEN);
      return false;
    }
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView) throws Exception {
    // your code
  }

  private void generarError(HttpServletResponse response, HttpStatus status) throws Exception{
    response.setStatus(status.value());
    response.setContentType("application/json");
    String mensaje = "";
    switch (status){
      case FORBIDDEN:
        mensaje = "Acceso no autorizado a la aplicación";
        break;
      case BAD_REQUEST:
        mensaje = "Petición erronea, revise headers y DTO";
        break;
      default:
        mensaje = "Código de error http no definido";
        break;
    }
    response.getWriter().write(
        objectMapper.writeValueAsString(
            new ErrorDto(
                mensaje,
                new Date().getTime())
        ));
  }
}
