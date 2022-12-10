package ingsoft.truequeandoback.controller.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorDto implements Serializable {
  private final String mensaje;
  private final long timeStampError;
}
