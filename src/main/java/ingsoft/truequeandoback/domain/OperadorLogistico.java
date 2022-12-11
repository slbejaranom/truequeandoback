package ingsoft.truequeandoback.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "2")
public class OperadorLogistico extends Usuario {

  private String nit;
  private float precioKilogramo;
  private float precioKilometro;
  private float precioMetroCubico;
}