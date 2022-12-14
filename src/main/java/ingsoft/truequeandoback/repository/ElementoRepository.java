package ingsoft.truequeandoback.repository;

import ingsoft.truequeandoback.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import ingsoft.truequeandoback.domain.Elemento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElementoRepository extends JpaRepository<Elemento, Integer> {

  Optional<Elemento> findById(int id);

  List<Elemento> findAllByClienteEmail(String email);

  @Query(value = "select * from Elementos elemento where elemento.idusuario <> ?1 and elemento.estado = true", nativeQuery = true)
  List<Elemento> findAllElementosQueNoPertenecenAlUsuario(int usuarioId);
}
