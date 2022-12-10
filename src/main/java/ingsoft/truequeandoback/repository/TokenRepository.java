package ingsoft.truequeandoback.repository;

import ingsoft.truequeandoback.domain.TokenDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<TokenDTO, Integer> {

  Optional<TokenDTO> findByValorToken(String valorToken);
}
