package ingsoft.truequeandoback.service;

import com.sun.jdi.request.DuplicateRequestException;
import ingsoft.truequeandoback.domain.Elemento;
import ingsoft.truequeandoback.domain.Trueque;
import ingsoft.truequeandoback.domain.Usuario;
import ingsoft.truequeandoback.repository.ElementoRepository;
import ingsoft.truequeandoback.repository.TruequeRepository;
import ingsoft.truequeandoback.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TruequeandoService {
    private final ElementoRepository elementoRepository;
    private final TruequeRepository truequeRepository;
    private final UsuarioRepository usuarioRepository;

    public Elemento registrarElemento (Elemento elemento){
        //generar las escepciones para error en caso que halla algo nulo
        // validar que el rol sea usuario
        elemento.setEstado(true);
        return elementoRepository.save(elemento);
    }

    public List<Elemento> listarObetosUsuario(int id){
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(id);
        if (!usuarioBuscado.isPresent()){
            //throw new FileSystemNotFoundException("El usuario no existe");
            throw new IllegalArgumentException("El usuario no existe");
        }
        Usuario usuario = usuarioBuscado.get();
        if(usuario.getRol()!=1){
            throw new IllegalArgumentException("Este usuario no contiene elementos");
        }
        List<Elemento> elementosUsuario;
        return  elementosUsuario = elementoRepository.findAllByClienteId(id);
    }
    public Trueque propuestaTrueque (Trueque trueque){
        // Validar que los objetos del truque esten activos
        // Cambiar el estado de los objetos a no activos
        // Guardar el trueque
        if (!trueque.getElemento1().isEstado()||!trueque.getElemento2().isEstado()){
            throw new IllegalArgumentException("Uno de los objetos no esta disponible para trueque");
        }
        trueque.getElemento1().setEstado(false);
        trueque.getElemento2().setEstado(false);
        trueque.setEstado(0);
        trueque.setFecha(new Date());
        return truequeRepository.save(trueque);
    }

}
