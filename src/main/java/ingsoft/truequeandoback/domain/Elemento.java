package ingsoft.truequeandoback.domain;

import lombok.Data;

@Data
public class Elemento {

    public float calcularVolumen(){
        return this.altura*this.anchura*this.longitud;
    }

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
