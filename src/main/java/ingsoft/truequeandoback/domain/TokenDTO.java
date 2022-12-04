package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Id;

@Data
public class TokenDTO {

    @Id
    private long id;

    private boolean activo;
    private int tiempoExpiracion;
    private long timestampGenetacion;
}
