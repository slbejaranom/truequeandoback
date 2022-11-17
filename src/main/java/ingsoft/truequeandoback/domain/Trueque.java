package ingsoft.truequeandoback.domain;

import lombok.Data;

@Data
public class Trueque {
    
    private int estado;
    private Date fecha;
    private long id;
    private OperadorLogistico transportador;
    
}
