package utez.mx.edu.userticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.mx.edu.userticket.model.Ticket.Ticket;

public interface TicketInterface extends JpaRepository<Ticket, Long> {
}
