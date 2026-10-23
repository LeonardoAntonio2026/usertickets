package utez.mx.edu.userticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utez.mx.edu.userticket.model.User;

public interface UserInterface extends JpaRepository<User,Long> {

}
