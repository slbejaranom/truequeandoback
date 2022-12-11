package ingsoft.truequeandoback.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1")
public class Cliente extends Usuario {

  private String departamento;
  private String direccion;
  private String municipio;
  @OneToMany(mappedBy = "cliente")
  @JsonManagedReference
  private List<Elemento> listaElementos;
}
