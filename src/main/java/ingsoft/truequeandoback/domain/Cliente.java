package ingsoft.truequeandoback.domain;

import java.util.List;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="cliente")
public class Cliente extends Usuario {
    private String departamento;
    private String direccion;
    private String municipio;
    private List<Elemento> listaElementos;
}
