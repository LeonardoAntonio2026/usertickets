package utez.mx.edu.userticket.service;

import org.springframework.stereotype.Service;
import utez.mx.edu.userticket.controller.usuario.dto.DesactivarUsuarioDto;
import utez.mx.edu.userticket.model.Ticket.Ticket;
import utez.mx.edu.userticket.model.User;
import utez.mx.edu.userticket.repository.UserInterface;

@Service
public class UsuarioService {
    private final UserInterface userInterface;

    public UsuarioService(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public User DesactivarUsuario(DesactivarUsuarioDto dto){
        User user = userInterface.findById(dto.getUserId()).orElseThrow();
        user.setActivo(false);
        return userInterface.save(user);
    }
}

