package ingsoft.truequeandoback.repository;

import ingsoft.truequeandoback.domain.Elemento;
import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.Usuario;
import java.util.Optional;

public interface UsuarioRepository<T extends Usuario> extends JpaRepository<T, Integer> {
  Optional<Usuario> findById(int id);
  Optional<T> findByEmail(String email);

}
