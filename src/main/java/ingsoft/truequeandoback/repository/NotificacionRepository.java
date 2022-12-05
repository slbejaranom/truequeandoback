package ingsoft.truequeandoback.repository;

import ingsoft.truequeandoback.domain.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository<T extends Notificacion> extends JpaRepository<T, Integer> {
}
