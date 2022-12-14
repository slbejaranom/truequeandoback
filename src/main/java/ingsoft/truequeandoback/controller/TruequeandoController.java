package ingsoft.truequeandoback.controller;

import ingsoft.truequeandoback.domain.*;
import ingsoft.truequeandoback.service.TruequeandoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import static ingsoft.truequeandoback.utils.Constants.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TruequeandoController {

  private final ServicioAutenticacion servicioAutenticacion;
  private final TruequeandoService truequeandoService;

  @PostMapping(RUTA_IDENTIFICARSE_EN_SISTEMA)
  public AutenticacionDTO autenticar(@RequestBody Usuario usuario) {
    return servicioAutenticacion.autenticar(usuario.getEmail(), usuario.getPassword());
  }

  @PostMapping(RUTA_REGISTRARSE_EN_SISTEMA)
  public Usuario registrar(@RequestBody Cliente usuario) {
    return servicioAutenticacion.registrar(usuario);
  }

  @PostMapping(RUTA_REGISTRAR_OBJETO)
  public Elemento registrarElemento(@RequestBody Elemento elemento) {
    return truequeandoService.registrarElemento(elemento);
  }

  @PostMapping(RUTA_HACER_PROPUESTA_TRUEQUE)
  public Trueque propuestaTrueque(@RequestBody Trueque trueque) {
    return truequeandoService.propuestaTrueque(trueque);
  }

  @GetMapping(RUTA_LISTAR_ELEMENTOS_USUARIO)
  public List<Elemento> listarObjetosUsuario(@RequestParam String email) {
    return truequeandoService.listarObjetosUsuario(email);
  }

  @GetMapping(RUTA_LISTAR_TRUEQUES_HECHOS_POR_USUARIO)
  public List<Trueque> listarTruequesHechosPorUsuario(@RequestParam String email) {
    return truequeandoService.listarTruequesHechosPorUsuario(email);
  }

  @GetMapping(RUTA_LISTAR_TRUEQUES_HECHOS_A_USUARIO)
  public List<Trueque> listarTruequesHechosAUsuario(@RequestParam String email) {
    return truequeandoService.listarTruequesHechosAUsuario(email);
  }

  @PutMapping(RUTA_ACEPTAR_TRUEQUES)
  public Trueque aceptarTrueque(@RequestBody Trueque trueque) {
    return truequeandoService.aceptarTrueque(trueque);
  }

  @PutMapping(RUTA_CERRAR_TRUEQUE)
  public Trueque cerrarTrueque(@RequestBody Trueque trueque) {
    return truequeandoService.cerrarTrueque(trueque);
  }

  @PutMapping(RUTA_RECHAZAR_TRUEQUE)
  public Trueque cancelarTrueque(@RequestBody Trueque trueque){
    return truequeandoService.cancelarTrueque(trueque);
  }


  @GetMapping(RUTA_LISTAR_TRUEQUES_ACEPTADOS)
  public List<Trueque> listarTruequesAceptados() {
    return truequeandoService.listarTruequesAceptados();
  }

  @GetMapping(RUTA_LISTAR_CATEGORIAS)
  public List<Categoria> listarCategorias() {
    return truequeandoService.listarCategorias();
  }

  @PostMapping(RUTA_AGREGAR_CATEGORIA)
  public Categoria agregarCategoria(@RequestBody Categoria categoria) {
    return truequeandoService.agregarCategoria(categoria);
  }

  @GetMapping(RUTA_LISTAR_OBJETOS_OTROS_USUARIOS)
  public List<Elemento> listarObjetosQueNoSonDelUsuario(@RequestParam String email) {
    return truequeandoService.listarObjetosOtrosUsuarios(email);
  }
}