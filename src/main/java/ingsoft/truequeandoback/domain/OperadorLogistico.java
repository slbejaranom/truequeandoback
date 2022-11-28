package ingsoft.truequeandoback.domain;
import java.util.List;

import lombok.Data;

@Data
public class OperadorLogistico extends Usuario {
    private float precioKilogramo;
    private float precioKilometro;
    private float precioMetroCubico;
}
