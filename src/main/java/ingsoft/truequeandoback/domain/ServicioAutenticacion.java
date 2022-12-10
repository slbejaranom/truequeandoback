package ingsoft.truequeandoback.domain;

import com.sun.jdi.request.DuplicateRequestException;
import ingsoft.truequeandoback.repository.TokenRepository;
import ingsoft.truequeandoback.repository.UsuarioRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import static ingsoft.truequeandoback.utils.Constants.RUTAS_ACCESIBLES_CLIENTE;
import static ingsoft.truequeandoback.utils.Constants.RUTAS_ACCESIBLES_TODOS;

@Data
@RequiredArgsConstructor
@Service
public class ServicioAutenticacion {

  @Value("${token.expiration-time}")
  private int timeExpiration;
  private final UsuarioRepository<Usuario> usuarioRepository;
  private final TokenRepository tokenRepository;

  public AutenticacionDTO autenticar(String email, String password) {
    Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
    AutenticacionDTO autenticacionDTO = new AutenticacionDTO();
    if (usuario.isPresent()) {
      Usuario usuarioLogin = usuario.get();
      if (usuarioLogin.getPassword().equals(password)) {
        TokenDTO token = generarTokenDto(usuarioLogin);
        token.setTiempoExpiracion(timeExpiration*1000);
        token.setUsuario(usuarioLogin);
        token.setActivo(true);
        token.setTimestampGeneracion(new Date().getTime());
        tokenRepository.save(token);
        autenticacionDTO.setToken(token.getValorToken());
        autenticacionDTO.setExpiresln(token.getTiempoExpiracion());
      } else {
        // contraseña incorrecta
        autenticacionDTO.setErrorMessage("Contraseña incorrecta");
      }

    } else {
      autenticacionDTO.setErrorMessage("Usuario no existe");
    }
    return autenticacionDTO;
  }

  public void cancelarToken(TokenDTO tokenDTO) {
    if (tokenDTO.isActivo()) {
        tokenDTO.setActivo(false);
        tokenRepository.save(tokenDTO);
      }
  }

  public boolean verificarTokenActivo(TokenDTO tokenDTO) {
    Optional<TokenDTO> tokenBuscado = tokenRepository.findByValorToken(tokenDTO.getValorToken());
    if (!tokenBuscado.isPresent()) {
      return false;
    }
    TokenDTO tokenValidar = tokenBuscado.get();
    if(!tokenValidar.isActivo()){
      return false;
    }
    if(new Date().getTime() > tokenValidar.getTimestampGeneracion()+tokenValidar.getTiempoExpiracion()){
      cancelarToken(tokenValidar);
      return false;
    }
    return true;
  }

  public Usuario registrar(Usuario usuario) {
    // Me entra un usuario sin Id
    // SI el usuario existe, es por email, es por que ya esta registrado y no se puede repetir
    // Si no existe me crea un usuario que es guardar el usuario en la base de datos con el save User
    Optional<Usuario> usuarioRegister = usuarioRepository.findByEmail(usuario.getEmail());
    if (usuarioRegister.isPresent()) {
      throw new DuplicateRequestException("Usuario ya existe");
    }
      return usuarioRepository.save(usuario); // devolver Usuario
  }

  public boolean verificarAccesoPorRol(String token, String ruta) {
    String[] tokenArgs = token.split(":");
    int rol = Integer.parseInt(tokenArgs[1]);
    switch (rol) {
      case 1:
        return RUTAS_ACCESIBLES_CLIENTE.contains(ruta) || RUTAS_ACCESIBLES_TODOS.contains(ruta);
      default:
        return false;
    }
  }

  private TokenDTO generarTokenDto(Usuario usuario) {
    // Usuario.email:ROL:Timestamp
    long timeStampNow = new Date().getTime();
    TokenDTO tokenDTO = new TokenDTO();
    tokenDTO.setTimestampGeneracion(timeStampNow);
    tokenDTO.setValorToken(Base64.getEncoder().encodeToString(
        (usuario.getEmail() + ":" + usuario.getRol() + ":" + timeStampNow).getBytes(
            StandardCharsets.UTF_8)));
    return tokenDTO;
  }
}
