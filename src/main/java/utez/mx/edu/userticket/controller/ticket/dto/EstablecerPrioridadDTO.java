package utez.mx.edu.userticket.controller.ticket.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import utez.mx.edu.userticket.model.Ticket.Prioridad;

@Data
public class EstablecerPrioridadDTO {
    private Long ticketId;
    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;
}
