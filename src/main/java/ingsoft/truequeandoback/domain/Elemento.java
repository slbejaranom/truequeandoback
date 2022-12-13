package ingsoft.truequeandoback.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Getter
@Setter
@Entity
@Table(name = "elementos")
public class Elemento {

  @Id
  @SequenceGenerator(name = "elementos_id_seq", sequenceName = "elementos_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elementos_id_seq")
  private int id;
  private float altura;
  private float anchura;
  private float longitud;
  private int categoria;
  private boolean estado;
  private String nombre;
  private float peso;
  private float valor;
  @Lob
  @Type(type="org.hibernate.type.BinaryType")
  private byte[] imagen;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idusuario", nullable = false)
  @JsonBackReference
  private Cliente cliente;

  public float calcularVolumen() {
    float volumen;
    if (this.altura > 0 && this.anchura > 0 && this.longitud > 0) {
      volumen = this.altura * this.anchura * this.longitud;
    } else {
      volumen = -2;
    }
    return volumen;
  }
}
