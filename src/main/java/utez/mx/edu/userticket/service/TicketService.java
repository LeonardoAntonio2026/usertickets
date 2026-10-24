package utez.mx.edu.userticket.service;

import org.springframework.stereotype.Service;
import utez.mx.edu.userticket.controller.ticket.dto.CrearTicketDTO;
import utez.mx.edu.userticket.controller.ticket.dto.EstablecerPrioridadDTO;
import utez.mx.edu.userticket.controller.ticket.dto.EstadoTicketDto;
import utez.mx.edu.userticket.model.Ticket.Estado;
import utez.mx.edu.userticket.model.Ticket.Ticket;
import utez.mx.edu.userticket.repository.TicketInterface;
import utez.mx.edu.userticket.repository.UserInterface;

@Service
public class TicketService {

    final UserInterface userInterface;
    final TicketInterface ticketInterface;


    public TicketService(UserInterface userInterface, TicketInterface ticketInterface) {
        this.userInterface = userInterface;
        this.ticketInterface = ticketInterface;
    }

    public Ticket CrearTicket(CrearTicketDTO dto){
        Ticket ticket = new Ticket();
        ticket.setDescripcion(dto.getDescricion());
        ticket.setPrioridad(dto.getPrioridad());
        ticket.setEstado(Estado.ABIERTO);
        ticket.setUsuario(userInterface.findById(dto.getUserId()).orElseThrow());

        return ticketInterface.save(ticket);
    }

    public Ticket EstadoTicket(EstadoTicketDto dto){
        Ticket ticket = ticketInterface.findById(dto.getTicketId()).orElseThrow();
        if (ticket.getEstado() == Estado.ABIERTO){
            ticket.setEstado(Estado.EN_PROCESO);
        } else if (ticket.getEstado() == Estado.EN_PROCESO) {
            ticket.setEstado(Estado.CERRADO);
        } else if(ticket.getEstado() == Estado.CERRADO){
            System.out.println("xd");
        }

        return ticketInterface.save(ticket);

    }

    public Ticket EstablecerPriodidad(EstablecerPrioridadDTO dto){
        Ticket ticket = ticketInterface.findById(dto.getTicketId()).orElseThrow();
        if(ticket.getEstado() != Estado.CERRADO){
            ticket.setPrioridad(dto.getPrioridad());
        } else{
            System.out.println("esta cerrado");
        }
        return ticketInterface.save(ticket);
    }
}
