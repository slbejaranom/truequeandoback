package ingsoft.truequeandoback.controller;

import ingsoft.truequeandoback.domain.*;
import ingsoft.truequeandoback.service.TruequeandoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping(RUTA_LISTAR_ELEMENTOS_USUARIO)
  public List<Elemento> listarObetosUsuario(@RequestParam int id){return truequeandoService.listarObetosUsuario(id);}
}


//http://localhost:5555/listarelementosusuario?id=