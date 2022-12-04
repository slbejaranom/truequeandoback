package ingsoft.truequeandoback.domain;

import lombok.Data;

@Data
public class NotificacionElemento extends Notificacion {
    @Override
    public void notificar(){
        
    }

    private Cliente clienteAsociado;
    private Elemento elementoAsociado;
    private int tipoNotificacion;
}
