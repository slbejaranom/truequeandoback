package ingsoft.truequeandoback.domain;

import java.util.List;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
public class Cliente extends Usuario {
    private String departamento;
    private String direccion;
    private String municipio;
    @OneToMany(mappedBy = "cliente")
    private List<Elemento> listaElementos;
}
