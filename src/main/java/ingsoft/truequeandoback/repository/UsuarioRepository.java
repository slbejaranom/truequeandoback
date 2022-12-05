package ingsoft.truequeandoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository<T extends Usuario> extends JpaRepository<T,Integer> {
    Optional<T> findByEmail(String email);


    //List<Usuario> findByEmailAndPassword(String email, String password);

}
