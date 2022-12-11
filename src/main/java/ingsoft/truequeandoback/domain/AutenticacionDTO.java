package ingsoft.truequeandoback.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticacionDTO {

  private String errorMessage;
  private int expiresln;
  private String token;
}
