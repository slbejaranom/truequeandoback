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
    private int id;
    @Column(columnDefinition = "DATE")
    private Date fecha;
    private String mensaje;
}
