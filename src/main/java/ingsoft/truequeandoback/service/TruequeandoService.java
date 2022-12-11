package ingsoft.truequeandoback.service;

import ingsoft.truequeandoback.domain.Elemento;
import ingsoft.truequeandoback.domain.Trueque;
import ingsoft.truequeandoback.domain.Usuario;
import ingsoft.truequeandoback.repository.ElementoRepository;
import ingsoft.truequeandoback.repository.TruequeRepository;
import ingsoft.truequeandoback.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TruequeandoService {
    private final ElementoRepository elementoRepository;
    private final TruequeRepository truequeRepository;
    private final UsuarioRepository<Usuario> usuarioRepository;

    public Elemento registrarElemento (Elemento elemento){
        //generar las escepciones para error en caso que halla algo nulo
        // validar que el rol sea usuario
        elemento.setEstado(true);
        return elementoRepository.save(elemento);
    }
    public Trueque propuestaTrueque (Trueque trueque){
        log.info("Inicio de registro propuesta trueque");
        // Validar que los objetos del truque esten activos
        // Cambiar el estado de los objetos a no activos
        // Guardar el trueque
        Optional<Elemento> elemento1 = elementoRepository.findById(trueque.getElemento1().getId());
        Optional<Elemento> elemento2 = elementoRepository.findById(trueque.getElemento2().getId());
        if(elemento1.isEmpty()){
            log.info("No se encuentra elemento 1 con id {}", trueque.getElemento1().getId());
            throw new IllegalArgumentException("No se encuentra elemento 1 con ese id");
        }
        Elemento elementoDado = elemento1.get();
        if(elemento2.isEmpty()){
            log.info("No se encuentra elemento 1 con id {}", trueque.getElemento2().getId());
            throw new IllegalArgumentException("No se encuentra elemento 2 con ese id");
        }
        Elemento elementoRecibido = elemento2.get();
        if (!elementoDado.isEstado()||!elementoRecibido.isEstado()){
            throw new IllegalArgumentException("Uno de los objetos no esta disponible para trueque");
        }
        elementoDado.setEstado(false);
        elementoRecibido.setEstado(false);
        trueque.setElemento1(elementoDado);
        trueque.setElemento2(elementoRecibido);
        trueque.setEstado(0);
        trueque.setFecha(new Date());
        return truequeRepository.save(trueque);
    }

}
