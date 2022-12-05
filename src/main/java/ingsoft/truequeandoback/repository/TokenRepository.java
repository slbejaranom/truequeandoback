package ingsoft.truequeandoback.repository;

import ingsoft.truequeandoback.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.TokenDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository <T extends TokenDTO>  extends JpaRepository<T,Integer> {
    Optional<T> findByValorToken(String valorToken);
}
