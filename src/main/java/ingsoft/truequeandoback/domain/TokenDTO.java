package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="token")
public class TokenDTO {

    @Id
    private long id;

    private boolean activo;
    private int tiempoExpiracion;
    private long timestampGenetacion;
}
