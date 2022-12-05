package ingsoft.truequeandoback.controller;

import ingsoft.truequeandoback.domain.AutenticacionDTO;
import ingsoft.truequeandoback.domain.ServicioAutenticacion;
import ingsoft.truequeandoback.domain.Usuario;
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
    @PostMapping("/autenticar")
    public AutenticacionDTO autenticar (@RequestBody Usuario usuario){
        return servicioAutenticacion.autenticar(usuario.getEmail(), usuario.getPassword());
    }

    @PostMapping("/registrar")
    public AutenticacionDTO registrar (@RequestBody Usuario usuario){
        return servicioAutenticacion.registrar(usuario);
    }
}
