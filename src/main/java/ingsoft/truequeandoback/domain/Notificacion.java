package ingsoft.truequeandoback.domain;

import lombok.Data;

@Data
public class Notificacion {

    public void notificar(){
        
    }

    private long id;
    private Date fecha;
    private String mensaje;
}
