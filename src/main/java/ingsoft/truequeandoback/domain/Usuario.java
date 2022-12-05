package ingsoft.truequeandoback.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rol", discriminatorType = DiscriminatorType.INTEGER)
public class Usuario {
    
    @Id
    private int id;
    private String email;    
    private String nombre;
    private String password;
    @Column(name="rol", insertable = false, updatable = false)
    private int rol;
}
