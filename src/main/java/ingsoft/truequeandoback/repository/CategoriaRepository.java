package ingsoft.truequeandoback.repository;

import ingsoft.truequeandoback.domain.Categoria;
import ingsoft.truequeandoback.domain.Trueque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    List<Categoria> findAll();
    Optional<Categoria> findByDescripcion(String descripcion);
}
