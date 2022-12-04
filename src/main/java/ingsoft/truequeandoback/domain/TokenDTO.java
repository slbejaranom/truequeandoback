package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="tokens")
public class TokenDTO {

    @Id
    private int id;

    private String valorToken;
    private boolean activo;
    private int tiempoExpiracion;
    private long timestampGeneracion;
}
