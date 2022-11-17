package ingsoft.truequeandoback.domain;
import java.util.List;

import lombok.Data;

@Data
public class OperadorLogistico extends Usuario {
    private Real precioKilogramo;
    private Real precioKilometro;
    private Real precioMetroCubico;
}
