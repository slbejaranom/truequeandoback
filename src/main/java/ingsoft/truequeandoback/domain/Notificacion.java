package ingsoft.truequeandoback.domain;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Notificacion {

    public abstract void notificar();

    private long id;
    private Date fecha;
    private String mensaje;
}
