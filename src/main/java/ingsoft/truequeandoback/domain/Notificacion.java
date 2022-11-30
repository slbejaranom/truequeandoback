package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Notificacion {

    public abstract void notificar();

    @Id
    private long id;
    private Date fecha;
    private String mensaje;
}
