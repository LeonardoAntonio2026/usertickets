package utez.mx.edu.userticket.controller.usuario.dto;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.mx.edu.userticket.controller.ticket.dto.CrearTicketDTO;
import utez.mx.edu.userticket.model.Ticket.Ticket;
import utez.mx.edu.userticket.model.User;
import utez.mx.edu.userticket.repository.UserInterface;
import utez.mx.edu.userticket.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UsuarioService usuarioService;

    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PutMapping("/desactivar")
    public ResponseEntity<User> cambiarEstado(@RequestBody @Valid DesactivarUsuarioDto payload){
        return ResponseEntity.status(201).body(usuarioService.DesactivarUsuario(payload));
    }
}
