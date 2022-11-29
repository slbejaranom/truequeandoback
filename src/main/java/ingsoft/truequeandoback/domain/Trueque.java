package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class Trueque {

    @Id
    private long id;

    private int estado;
    private Date fecha;
    private OperadorLogistico transportador;
    
}

