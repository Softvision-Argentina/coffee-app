package main.repository;

import main.dto.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

/** Los parámetros de esta interfaz son: la entidad a gestionar (Client)
 * y el tipo de dato de su clave primaria (Long) **/