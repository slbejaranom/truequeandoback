package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="tokens")
public class TokenDTO {


    @Id
    @SequenceGenerator(name="tokens_id_seq", sequenceName = "tokens_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tokens_id_seq")
    private int id;

    private String valorToken;
    private boolean activo;
    private int tiempoExpiracion;
    private long timestampGeneracion;
    @ManyToOne
    @JoinColumn(name="idusuario")
    private Usuario usuario;


}
