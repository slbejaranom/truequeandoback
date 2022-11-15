package ingsoft.truequeandoback.domain;

import lombok.Data;

public class Elemento {
    

    public Real calcularVolumen(){
        return this.altura*this.anchura*this.longitud;
    }

    public long getIdElemento (){
        return this.id;
   }
   
   public void setIdElemento (long _id){
       this.id = _id;
   }

   public long getAlturaElemento (){
        return this.altura;
    }

    public void setAlturaElemento (Real altura){
        this.altura = altura;
    }

    public Real getAnchuraElemento (){
        return this.anchura;
    }
    
    public void setAnchuraElemento (Real anchura){
        this.anchura = anchura;
    }    

    public Real getLongitudElemento (){
        return this.longitud;
    }
    
    public void setLongitudElemento (Real longitud){
        this.longitud = longitud;
    }   

    public int getCategoriaElemento (){
        return this.categoria;
    }
    
    public void setCategoriaElemento (int categoria){
        this.categoria = categoria;
    }  

    public boolean getEstadoElemento (){
        return this.estado;
    }
    
    public void setEstadoElemento (boolean estado){
        this.estado = estado;
    }  

    public String getNombreElemento (){
        return this.nombre;
    }
    
    public void setNombreElemento (String nombre){
        this.nombre = nombre;
    } 

    public Real getPesoElemento (){
        return this.peso;
    }
    
    public void setLongitudElemento (Real peso){
        this.peso = peso;
    }   

    public Real getValorElemento (){
        return this.valor;
    }
    
    public void setValorElemento (Real valor){
        this.valor = valor;
    } 

    public Cliente getClienteElemento (){
        return this.cliente;
    }
    
    public void setClienteElemento (Cliente cliente){
        this.cliente = cliente;
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
