package cr.ac.ucr.demo.Repository;

import cr.ac.ucr.demo.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
}
