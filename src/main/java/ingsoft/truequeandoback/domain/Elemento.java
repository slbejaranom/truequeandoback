package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Elemento {

    public float calcularVolumen(){
        return this.altura*this.anchura*this.longitud;
    }

    @Id
    private  long id;
    private float altura;
    private float anchura;
    private float longitud;
    private int categoria;
    private boolean estado;
    private String nombre;
    private float peso;
    private float valor;
    private Cliente cliente;
}
