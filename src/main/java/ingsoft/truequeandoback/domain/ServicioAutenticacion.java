package ingsoft.truequeandoback.domain;

import ingsoft.truequeandoback.domain.AutenticacionDTO;
import ingsoft.truequeandoback.domain.TokenDTO;
import ingsoft.truequeandoback.domain.Usuario;
import lombok.Data;

@Data
public class ServicioAutenticacion {
    public AutenticacionDTO autenticar(Usuario){

    }
    public void cancelarToken(TokenDTO) {
        
    }
    public boolean verificarAcceso(TokenDTO) {
        
    }
    public boolean verificarTokenActivo(TokenDTO) {
        
    }
}
