package cl.fabioladiaz.contactos.repositorio;

import cl.fabioladiaz.contactos.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRespositorio extends JpaRepository<Contacto, Integer> {

}
