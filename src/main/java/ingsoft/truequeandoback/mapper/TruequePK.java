package ingsoft.truequeandoback.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TruequePK implements Serializable {

  private int id;
  private Date fecha;
}
