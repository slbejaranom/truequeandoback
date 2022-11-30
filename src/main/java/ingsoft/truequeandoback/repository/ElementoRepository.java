package ingsoft.truequeandoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.Elemento;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementoRepository extends JpaRepository<Elemento,Long> {

}
