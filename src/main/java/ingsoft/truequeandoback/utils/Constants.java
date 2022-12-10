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

  public  static final String RUTA_ERROR = "/error";

  public static final Set<String> RUTAS_ACCESIBLES_TODOS = Set.of(
      RUTA_REGISTRARSE_EN_SISTEMA,
      RUTA_IDENTIFICARSE_EN_SISTEMA,
      RUTA_ERROR    );

  public static final Set<String> RUTAS_ACCESIBLES_CLIENTE = Set.of(
      RUTA_REGISTRAR_OBJETO,
      RUTA_HACER_PROPUESTA_TRUEQUE,
      RUTA_GESTIONAR_TRUEQUE
  );

  public static final Pattern PATRON_REGEX_TOKEN = Pattern.compile(
      "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?:[0-9]+:[0-9]+", Pattern.CASE_INSENSITIVE);
}
