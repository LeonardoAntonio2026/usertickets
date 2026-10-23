package utez.mx.edu.userticket.controller.ticket.dto;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.mx.edu.userticket.model.Ticket.Ticket;
import utez.mx.edu.userticket.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping()
    public ResponseEntity<Ticket> crear(@RequestBody @Valid CrearTicketDTO payload){
        return ResponseEntity.status(201).body(ticketService.CrearTicket(payload));
    }

    @PostMapping("/actualizarEstado")
    public ResponseEntity<Ticket> actualizarEstado(@RequestBody @Valid EstadoTicketDto payload){
        return ResponseEntity.status(201).body(ticketService.EstadoTicket(payload));
    }

    @PostMapping("/editarPrioridad")
    public ResponseEntity<Ticket> actualizarEstado(@RequestBody @Valid EstablecerPrioridadDTO payload){
        return ResponseEntity.status(201).body(ticketService.EstablecerPriodidad(payload));
    }
}
