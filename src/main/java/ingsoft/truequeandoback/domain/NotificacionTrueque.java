package ingsoft.truequeandoback.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class NotificacionTrueque extends Notificacion {

    @Override
    public void notificar(){
        
    }
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="idtrueque", referencedColumnName = "id"),
            @JoinColumn(name="fechatrueque", referencedColumnName = "fecha")
    })
    private Trueque trueque;
}
