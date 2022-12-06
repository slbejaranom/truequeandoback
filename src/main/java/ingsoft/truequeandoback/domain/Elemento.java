package ingsoft.truequeandoback.domain;

import ingsoft.truequeandoback.repository.ElementoRepository;
import ingsoft.truequeandoback.repository.UsuarioRepository;
import lombok.Data;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@Table(name="elementos")
public class Elemento {
    //private final ElementoRepository ElementoRepository;
    public float calcularVolumen( ){
        float volumen;
        if (this.altura > 0 && this.anchura > 0 && this.longitud > 0) {
            volumen = this.altura * this.anchura * this.longitud;
        }
        else {
            volumen = -2;
        }
        return volumen;
    }

    @Id
    @SequenceGenerator(name="elementos_id_seq", sequenceName = "elementos_id_seq", allocationSize = 1)
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
    @ManyToOne
    @JoinColumn(name="idusuario", nullable = false)
    private Cliente cliente;
}
