package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "administrador")
public class Administrador extends Usuario {
    
}
