package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class NotificacionElemento extends Notificacion {
    @Override
    public void notificar(){

    }
    @ManyToOne
    @JoinColumn(name="id", nullable = false, insertable = false, updatable = false)
    private Cliente clienteAsociado;
    @ManyToOne
    @JoinColumn(name="id", nullable = false, insertable = false, updatable = false)
    private Elemento elementoAsociado;
}
