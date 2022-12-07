package ingsoft.truequeandoback.controller;

import ingsoft.truequeandoback.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TruequeandoController {
    private final ServicioAutenticacion servicioAutenticacion;
    //private final Elemento elemento;
    @PostMapping("/autenticar")
    public AutenticacionDTO autenticar (@RequestBody Usuario usuario){
        return servicioAutenticacion.autenticar(usuario.getEmail(), usuario.getPassword());
    }

    @PostMapping("/registrar")
    public AutenticacionDTO registrar (@RequestBody Usuario usuario){
        return servicioAutenticacion.registrar(usuario);
    }

    @PostMapping("/verificarTokenActivo")
    public boolean verificarTokenActivo (@RequestBody TokenDTO tokenDTO){
        return servicioAutenticacion.verificarTokenActivo(tokenDTO);
    }

    @PostMapping("/cancelarToken")
    public void cancelarToken (@RequestBody TokenDTO tokenDTO){
        servicioAutenticacion.cancelarToken(tokenDTO);
    }

    /*@PostMapping("/calcularVolumen")
    public float calcularVolumen (@RequestBody Elemento elemento){
        return elemento.calcularVolumen(elemento);
    }*/

}
