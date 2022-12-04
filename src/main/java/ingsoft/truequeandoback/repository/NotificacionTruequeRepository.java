package ingsoft.truequeandoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.NotificacionTrueque;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionTruequeRepository extends JpaRepository<NotificacionTrueque,Long> {

}
