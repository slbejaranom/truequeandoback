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
    @SequenceGenerator(name="usuarios_id_seq", sequenceName = "usuarios_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_id_seq")
    private int id;
    private String email;    
    private String nombre;
    private String password;
    @Column(name="rol", insertable = false, updatable = false)
    private int rol;
}
