package ingsoft.truequeandoback.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Data
public class TruequePK implements Serializable {

  private int id;
  private Date fecha;
}
