package ingsoft.truequeandoback.mapper;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
public class TruequePK implements Serializable {

  private int id;
  private Date fecha;
}
