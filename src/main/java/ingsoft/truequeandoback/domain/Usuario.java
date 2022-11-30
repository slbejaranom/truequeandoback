package ingsoft.truequeandoback.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    private long id;
    private String email;    
    private String nombre;
    private String password; 
}
