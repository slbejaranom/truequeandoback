package ingsoft.truequeandoback.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.Trueque;
import org.springframework.stereotype.Repository;

@Repository
public interface TruequeRepository extends JpaRepository<Trueque, Long> {

  List<Trueque> findAllByUsuario1Email(String email);

  List<Trueque> findAllByUsuario2Email(String email);
}
