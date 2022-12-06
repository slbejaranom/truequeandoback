package ingsoft.truequeandoback.repository;

import ingsoft.truequeandoback.domain.TokenDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.Elemento;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementoRepository <T extends Elemento>  extends JpaRepository<T,Integer> {
    Optional<T> findById(int id);

}
