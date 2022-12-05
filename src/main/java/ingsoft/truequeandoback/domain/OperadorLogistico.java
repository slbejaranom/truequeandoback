package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@DiscriminatorValue(value = "2")
public class OperadorLogistico extends Usuario {
    private String nit;
    private float precioKilogramo;
    private float precioKilometro;
    private float precioMetroCubico;
}