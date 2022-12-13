package ingsoft.truequeandoback.utils;

import java.util.Set;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

  public static final String RUTA_REGISTRARSE_EN_SISTEMA = "/registrarusuario";
  public static final String RUTA_IDENTIFICARSE_EN_SISTEMA = "/autenticarusuario";
  public static final String RUTA_REGISTRAR_OBJETO = "/registrarobjeto";
  public static final String RUTA_HACER_PROPUESTA_TRUEQUE = "/propuestatrueque";
  public static final String RUTA_GESTIONAR_TRUEQUE = "/gestionartrueque";
  public static final String RUTA_ENTREGAR_TRUEQUE = "/entregartrueque";
  public static final String RUTA_ERROR = "/error";
  public static final String RUTA_LISTAR_ELEMENTOS_USUARIO = "/listarelementosusuario";
  public static final String RUTA_LISTAR_TRUEQUES_HECHOS_POR_USUARIO = "/truequeshechosusuario";
  public static final String RUTA_LISTAR_TRUEQUES_HECHOS_A_USUARIO = "/truequesrecibidosusuario";
  public static final String RUTA_ACEPTAR_TRUEQUES = "/aceptartrueque";
  public static final String RUTA_CERRAR_TRUEQUE = "/cerrartrueque";
  public static final String RUTA_RECHAZAR_TRUEQUE = "/rechazartrueque";
  public static final String RUTA_LISTAR_TRUEQUES_ACEPTADOS = "/listartruequesaceptados";
  public static final String RUTA_LISTAR_CATEGORIAS = "/listarcategoria";
  public static final String RUTA_AGREGAR_CATEGORIA = "/agregarcategoria";

  public static final Set<String> RUTAS_ACCESIBLES_TODOS = Set.of(
      RUTA_REGISTRARSE_EN_SISTEMA,
      RUTA_IDENTIFICARSE_EN_SISTEMA,
      RUTA_ERROR);

  public static final Set<String> RUTAS_ACCESIBLES_CLIENTE = Set.of(
      RUTA_REGISTRAR_OBJETO,
      RUTA_HACER_PROPUESTA_TRUEQUE,
      RUTA_GESTIONAR_TRUEQUE,
      RUTA_LISTAR_ELEMENTOS_USUARIO,
      RUTA_LISTAR_TRUEQUES_HECHOS_POR_USUARIO,
      RUTA_LISTAR_TRUEQUES_HECHOS_A_USUARIO,
          RUTA_ACEPTAR_TRUEQUES,
          RUTA_RECHAZAR_TRUEQUE,
          RUTA_LISTAR_CATEGORIAS,
          RUTA_RECHAZAR_TRUEQUE
  );

  public static final Set<String> RUTAS_ACCESIBLES_OPERADOR_LOGISTICO = Set.of(
          RUTA_CERRAR_TRUEQUE
  );

  public static final Set<String> RUTAS_ACCESIBLES_ADMINISTRADOR = Set.of(
          RUTA_AGREGAR_CATEGORIA,
          RUTA_LISTAR_CATEGORIAS
  );

  public static final Pattern PATRON_REGEX_TOKEN = Pattern.compile(
      "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?:[0-9]+:[0-9]+",
      Pattern.CASE_INSENSITIVE);
}
