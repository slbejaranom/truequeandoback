package ingsoft.truequeandoback.domain;

import ingsoft.truequeandoback.mapper.TruequePK;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "trueques")
@IdClass(TruequePK.class)
public class Trueque {

  @Id
  @SequenceGenerator(name = "trueques_id_seq", sequenceName = "trueques_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trueques_id_seq")
  private int id;

  private int estado;

  @Id
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @ManyToOne
  @JoinColumn(name = "idusuariool", nullable = false, insertable = false, updatable = false)
  private OperadorLogistico transportador;

  @ManyToOne
  @JoinColumn(name = "idusuario1", nullable = false, insertable = false, updatable = false)
  private Usuario usuario1; //quien inicia el trueque

  @ManyToOne
  @JoinColumn(name = "idusuario2", nullable = false, insertable = false, updatable = false)
  private Usuario usuario2; // quien recive el trueque

  @ManyToOne
  @JoinColumn(name = "idelemento1", nullable = false)
  private Elemento elemento1; // el que se quiere cambiar

  @ManyToOne
  @JoinColumn(name = "idelemento2", nullable = false)
  private Elemento elemento2; // el que se quiere recibir

}

