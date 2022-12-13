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
@CrossOrigin(origins = "*")
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
  public List<Trueque> listarTruequesHechosPorUsuario(@RequestParam String email){
    return truequeandoService.listarTruequesHechosPorUsuario(email);
  }

  @GetMapping(RUTA_LISTAR_TRUEQUES_HECHOS_A_USUARIO)
  public List<Trueque> listarTruequesHechosAUsuario(@RequestParam String email){
    return truequeandoService.listarTruequesHechosAUsuario(email);
  }

  @GetMapping(RUTA_ACEPTAR_TRUEQUES)
  public void aceptarTrueque(@RequestBody Trueque trueque){  }

  @GetMapping(RUTA_CERRAR_TRUEQUE)
  public void cerrarTrueque(Trueque trueque){}

  @GetMapping(RUTA_RECHAZAR_TRUEQUE)
  public void  cancelarTrueque(Trueque trueque){}

  @GetMapping(RUTA_LISTAR_TRUEQUES_ACEPTADOS)
  public List<Trueque> listarTruequesAceptados(){
    return truequeandoService.listarTruequesAceptados();
  }

  @GetMapping(RUTA_LISTAR_CATEGORIAS)
  public List<Categoria> listarCategorias() {return truequeandoService.listarCategorias();}

  @GetMapping(RUTA_AGREGAR_CATEGORIA)
  public Categoria agregarCategoria(@RequestBody Categoria categoria){return  truequeandoService.agregarCategoria(categoria);}
}