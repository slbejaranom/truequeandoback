package ingsoft.truequeandoback.domain;
package ingsoft.truequeandoback.domain;
import ingsoft.truequeandoback.domain.Notificacion;
import lombok.Data;

@Data
public class NotificacionElemento extends Notificacion {
    public void notificar(){
        
    }

    private Cliente clienteAsociado;
    private Elemento elementoAsociado;
    private int tipoNotificacion;
}
