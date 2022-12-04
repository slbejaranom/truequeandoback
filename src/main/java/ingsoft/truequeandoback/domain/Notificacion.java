package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public abstract class Notificacion {

    public abstract void notificar();

    @Id
    private long id;

    private Date fecha;
    private String mensaje;
}
