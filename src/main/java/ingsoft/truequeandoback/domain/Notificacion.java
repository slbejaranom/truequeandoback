package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "notificaciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_notificacion", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Notificacion {

  public abstract void notificar();

  @Id
  @SequenceGenerator(name = "notificaciones_id_seq", sequenceName = "notificaciones_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notificaciones_id_seq")
  private int id;
  @Column(columnDefinition = "DATE")
  private Date fecha;
  private String mensaje;
  @Column(name = "tipo_notificacion", insertable = false, updatable = false)
  private int tipoNotificacion;

}
