package ingsoft.truequeandoback.domain;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class Cliente extends Usuario {
    private String departamento;
    private String direccion;
    private String municipio;
    private List<Elemento> listaElementos = Arrays.asList(Elemento);
}
