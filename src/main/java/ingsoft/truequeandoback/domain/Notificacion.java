package ingsoft.truequeandoback.domain;

import lombok.Data;

@Data
public abstract class Notificacion {

    public abstract void notificar(){
        
    }

    private long id;
    private Date fecha;
    private String mensaje;
}
