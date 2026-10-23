package utez.mx.edu.userticket.controller.ticket.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import utez.mx.edu.userticket.model.Ticket.Estado;

@Data
public class EstadoTicketDto {
    private Long ticketId;
}
