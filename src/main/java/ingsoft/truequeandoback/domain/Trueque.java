package ingsoft.truequeandoback.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Trueque {
    
    private int estado;
    private Date fecha;
    private long id;
    private OperadorLogistico transportador;
    
}
