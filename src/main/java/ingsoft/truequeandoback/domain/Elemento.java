package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="elementos")
public class Elemento {

    public float calcularVolumen(){
        return this.altura*this.anchura*this.longitud;
    }

    @Id
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
