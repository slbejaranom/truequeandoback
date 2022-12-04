package ingsoft.truequeandoback.domain;

import lombok.Data;

@Data
public class NotificacionTrueque extends Notificacion {

    @Override
    public void notificar(){
        
    }

    private Trueque trueque;
}
