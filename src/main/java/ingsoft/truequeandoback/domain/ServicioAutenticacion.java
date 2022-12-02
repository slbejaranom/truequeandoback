package ingsoft.truequeandoback.domain;

import ingsoft.truequeandoback.repository.TokenRepository;
import ingsoft.truequeandoback.repository.UsuarioRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


import java.util.Optional;

@Data
@RequiredArgsConstructor
public class ServicioAutenticacion {
    @Value("${token.expiration-time}")
    private final int timeExpiration;
    private final UsuarioRepository usuarioRepository;
    private final TokenRepository tokenRepository;
    public AutenticacionDTO autenticar(String email, String password){
        Optional<Usuario> usuario = usuarioRepository.getByEmail(email);
        AutenticacionDTO autenticacionDTO = new AutenticacionDTO();
        if  (usuario.isPresent()){
            Usuario usuarioLogin = usuario.get();
            if (usuarioLogin.getPassword() == password){
                TokenDTO token =  TokenDTO.generarTokenDto(usuarioLogin);
                tokenRepository.save(token);
                autenticacionDTO.setToken(token.getValorToken());
                autenticacionDTO.setExpiresln(timeExpiration);
                autenticacionDTO.setErrorMessage("");
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
    public void cancelarToken(TokenDTO tokenDTO) {
        
    }
    public boolean verificarAcceso(TokenDTO tokenDTO) {
        
    }
    public boolean verificarTokenActivo(TokenDTO tokenDTO) {
        
    }
}
