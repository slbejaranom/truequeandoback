package ingsoft.truequeandoback.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class NotificacionElemento extends Notificacion {

  @Override
  public void notificar() {
    //ToDo implementar notificar elemento
  }

  @ManyToOne
  @JoinColumn(name = "idusuario", nullable = false, insertable = false, updatable = false)
  private Cliente clienteAsociado;
  @ManyToOne
  @JoinColumn(name = "idelemento", nullable = false, insertable = false, updatable = false)
  private Elemento elementoAsociado;
}
