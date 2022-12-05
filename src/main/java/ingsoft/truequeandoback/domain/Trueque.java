package ingsoft.truequeandoback.domain;

import ingsoft.truequeandoback.mapper.TruequePK;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="trueques")
@IdClass(TruequePK.class)
public class Trueque {

    @Id
    @SequenceGenerator(name="trueques_id_seq", sequenceName = "trueques_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trueques_id_seq")
    private int id;
    private int estado;
    @Id
    @Column(columnDefinition = "DATE")
    private Date fecha;
    @ManyToOne
    @JoinColumn(name="idusuariool", nullable = false)
    private OperadorLogistico transportador;
    
}

