package ingsoft.truequeandoback.controller;

import ingsoft.truequeandoback.domain.*;
import ingsoft.truequeandoback.service.TruequeandoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ingsoft.truequeandoback.utils.Constants.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TruequeandoController {

  private final ServicioAutenticacion servicioAutenticacion;
  private final TruequeandoService truequeandoService;
  @PostMapping(RUTA_IDENTIFICARSE_EN_SISTEMA)
  public AutenticacionDTO autenticar(@RequestBody Usuario usuario) {
    return servicioAutenticacion.autenticar(usuario.getEmail(), usuario.getPassword());
  }

  @PostMapping(RUTA_REGISTRARSE_EN_SISTEMA)
  public Usuario registrar(@RequestBody Usuario usuario) {
    return servicioAutenticacion.registrar(usuario);
  }

  @PostMapping(RUTA_REGISTRAR_OBJETO)
  public Elemento registrarElemento(@RequestBody Elemento elemento){return truequeandoService.registrarElemento(elemento);}

  @PostMapping(RUTA_HACER_PROPUESTA_TRUEQUE)
  public  Trueque propuestaTrueque(@RequestBody Trueque trueque){return  truequeandoService.propuestaTrueque(trueque);}

}


