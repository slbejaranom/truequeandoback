package ingsoft.truequeandoback.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "0")
public class Administrador extends Usuario {

}
