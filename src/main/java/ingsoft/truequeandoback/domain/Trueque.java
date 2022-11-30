package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="trueque")
public class Trueque {

    @Id
    private long id;

    private int estado;
    private Date fecha;
    private OperadorLogistico transportador;
    
}

