package ingsoft.truequeandoback.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario {
    
    @Id
    private long id;
    private String email;    
    private String nombre;
    private String password;
    private int rol;
}
