package ingsoft.truequeandoback.domain;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @SequenceGenerator(name = "categorias_id_seq", sequenceName = "categorias_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorias_id_seq")
    private int id;
    private String descripcion;

    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
    private List<Elemento> elementos;
}
