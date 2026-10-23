package utez.mx.edu.userticket.controller.ticket.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import utez.mx.edu.userticket.model.Ticket.Prioridad;

@Data
public class CrearTicketDTO {
    private String descricion;
    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    private Long userId;
}
