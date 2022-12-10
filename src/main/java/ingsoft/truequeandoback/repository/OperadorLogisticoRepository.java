package ingsoft.truequeandoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.OperadorLogistico;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorLogisticoRepository extends JpaRepository<OperadorLogistico, Long> {

}
