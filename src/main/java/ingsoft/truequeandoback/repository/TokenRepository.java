package ingsoft.truequeandoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.TokenDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<TokenDTO,Long> {

}
