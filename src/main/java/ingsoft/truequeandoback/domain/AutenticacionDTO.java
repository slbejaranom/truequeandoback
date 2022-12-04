package ingsoft.truequeandoback.domain;

import lombok.Data;

@Data
public class AutenticacionDTO {
    private String errorMessage;
    private int expiresln;
    private String token;
}
