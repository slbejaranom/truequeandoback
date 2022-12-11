package ingsoft.truequeandoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.Elemento;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElementoRepository extends JpaRepository<Elemento, Integer> {

  Optional<Elemento> findById(int id);

  List<Elemento> findAllByClienteId(int id);
}
