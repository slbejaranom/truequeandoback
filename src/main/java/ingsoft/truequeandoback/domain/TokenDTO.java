package ingsoft.truequeandoback.domain;

import lombok.Data;

@Data
public class TokenDTO {
    private boolean activo;
    private long id;
    private int tiempoExpiracion;
    private long timestampGenetacion;
}
