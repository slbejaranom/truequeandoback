package ingsoft.truequeandoback.domain;

import lombok.Data;

@Data
public class Elemento {
    

    public Real calcularVolumen(){
        return this.altura*this.anchura*this.longitud;
    }

    private  long id;
    private Real altura;
    private Real anchura;
    private Real longitud;
    private int categoria;
    private boolean estado;
    private String nombre;
    private Real peso;
    private Real valor;
    private Cliente cliente;
}
