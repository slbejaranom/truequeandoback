package ingsoft.truequeandoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.NotificacionElemento;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionElementoRepository extends JpaRepository<NotificacionElemento,Long> {

}
