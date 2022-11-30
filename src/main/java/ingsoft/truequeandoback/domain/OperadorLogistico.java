package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="operador_logistico")
public class OperadorLogistico extends Usuario {
    private float precioKilogramo;
    private float precioKilometro;
    private float precioMetroCubico;
}
