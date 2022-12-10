package ingsoft.truequeandoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.Trueque;
import org.springframework.stereotype.Repository;

@Repository
public interface TruequeRepository extends JpaRepository<Trueque, Long> {

}
