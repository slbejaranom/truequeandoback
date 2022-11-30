package ingsoft.truequeandoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.TokenDTO;

public interface TokenRepository extends JpaRepository<TokenDTO,Long> {

}
