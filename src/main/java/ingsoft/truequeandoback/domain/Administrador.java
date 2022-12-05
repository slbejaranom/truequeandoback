package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@DiscriminatorValue(value = "0")
public class Administrador extends Usuario {

    
}
