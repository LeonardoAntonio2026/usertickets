package utez.mx.edu.userticket.model.Ticket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utez.mx.edu.userticket.model.User;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ticket")
public class Ticket {
    @Id
    private Long id;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private Prioridad priodidad;

    @ManyToOne
    private User usuario;
}
