package ingsoft.truequeandoback.domain;

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

@Data
@RequiredArgsConstructor
@Service
public class ServicioAutenticacion {
    @Value("${token.expiration-time}")
    private int timeExpiration;
    private final UsuarioRepository usuarioRepository;
    private final TokenRepository tokenRepository;
    public AutenticacionDTO autenticar(String email, String password){
        Optional<? extends Usuario> usuario = usuarioRepository.findByEmail(email);
        AutenticacionDTO autenticacionDTO = new AutenticacionDTO();
        if  (usuario.isPresent()){
            Usuario usuarioLogin = usuario.get();
            if (usuarioLogin.getPassword().equals(password)){
                TokenDTO token =  generarTokenDto(usuarioLogin);
                token.setTiempoExpiracion(timeExpiration);
                tokenRepository.save(token);
                autenticacionDTO.setToken(token.getValorToken());
                autenticacionDTO.setExpiresln(token.getTiempoExpiracion());
            }
            else{
                // contraseña incorrecta
                autenticacionDTO.setErrorMessage("Contraseña incorrecta");
            }

        }else {
            autenticacionDTO.setErrorMessage("Usuario no existe");
        }
        return autenticacionDTO;
    }
    /*public void cancelarToken(TokenDTO tokenDTO) {
        
    }
    public boolean verificarAcceso(TokenDTO tokenDTO) {
        
    }
    public boolean verificarTokenActivo(TokenDTO tokenDTO) {
        
    }*/

    public AutenticacionDTO registrar(Usuario usuario){
        // Me entra un usuario sin Id
        // SI el usuario existe, es por email, es por que ya esta registrado y no se puede repetir
        // Si no existe me crea un usuario que es guardar el usuario en la base de datos con el save User
        Optional<Usuario> usuarioRegister = usuarioRepository.findByEmail(usuario.getEmail());
        AutenticacionDTO autenticacionDTO = new AutenticacionDTO();
        if  (usuarioRegister.isPresent()){
            autenticacionDTO.setErrorMessage("Usuario ya existe");
        }else {
            usuarioRepository.save(usuario);
            autenticacionDTO.setErrorMessage("El usuario ha sido registrado exitosamente");
        }
        return autenticacionDTO;
    }

    private TokenDTO generarTokenDto(Usuario usuario){
        // Usuario.email:ROL:Timestamp
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setValorToken(Base64.getEncoder().encodeToString((usuario.getEmail()+":"+usuario.getRol()+":"+new Date().getTime()).getBytes(StandardCharsets.UTF_8)));
        return  tokenDTO;
    }
}
