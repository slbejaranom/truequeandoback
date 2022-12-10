package ingsoft.truequeandoback.controller;

import ingsoft.truequeandoback.domain.*;
import ingsoft.truequeandoback.service.TruequeandoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ingsoft.truequeandoback.utils.Constants.RUTA_IDENTIFICARSE_EN_SISTEMA;
import static ingsoft.truequeandoback.utils.Constants.RUTA_REGISTRARSE_EN_SISTEMA;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TruequeandoController {

  private final ServicioAutenticacion servicioAutenticacion;
  private final TruequeandoService truequeandoService;
  @PostMapping(RUTA_IDENTIFICARSE_EN_SISTEMA)
  public AutenticacionDTO autenticar(@RequestBody Usuario usuario) {
    return servicioAutenticacion.autenticar(usuario.getEmail(), usuario.getPassword());
  }

  @PostMapping(RUTA_REGISTRARSE_EN_SISTEMA)
  public AutenticacionDTO registrar(@RequestBody Usuario usuario) {
    return servicioAutenticacion.registrar(usuario);
  }

  @PostMapping("/verificarTokenActivo")
  public boolean verificarTokenActivo(@RequestBody TokenDTO tokenDTO) {
    return servicioAutenticacion.verificarTokenActivo(tokenDTO);
  }

  @PostMapping("/cancelarToken")
  public void cancelarToken(@RequestBody TokenDTO tokenDTO) {
    servicioAutenticacion.cancelarToken(tokenDTO);
  }
}
