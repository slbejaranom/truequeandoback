package ingsoft.truequeandoback.config;

import ingsoft.truequeandoback.domain.ServicioAutenticacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Handler;

@Component
public class SessionInterceptor implements HandlerInterceptor  {
    @Autowired
    ServicioAutenticacion servicioAutenticacion;
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        // your code
            String ruta = request.getRequestURI();
            //servicioAutenticacion.verificarAcceso(He)
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
}
