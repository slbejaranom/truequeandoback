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
            @JoinColumn(name="id", referencedColumnName = "id", insertable = false, updatable = false),
            @JoinColumn(name="fecha", referencedColumnName = "fecha", insertable = false, updatable = false)
    })
    private Trueque trueque;
}
