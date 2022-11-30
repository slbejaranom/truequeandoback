package ingsoft.truequeandoback.domain;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Usuario {
    
    @Id
    private long id;

    private String email;    
    private String nombre;
    private String password; 
}
