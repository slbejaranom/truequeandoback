package ingsoft.truequeandoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
