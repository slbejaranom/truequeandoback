package ingsoft.truequeandoback.domain;

import lombok.Data;

@Data
public class Usuario {
    
    private long id;
    private String email;    
    private String nombre;
    private String password; 
}
