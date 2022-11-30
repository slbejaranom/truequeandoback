package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="notificacion_elemento")
public class NotificacionElemento extends Notificacion {
    @Override
    public void notificar(){

    }
    private Cliente clienteAsociado;
    private Elemento elementoAsociado;
    private int tipoNotificacion;
}
