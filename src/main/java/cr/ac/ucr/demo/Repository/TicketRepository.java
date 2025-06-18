package cr.ac.ucr.demo.Repository;

import cr.ac.ucr.demo.Model.Ticket;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class TicketRepository {

    private final ArrayList<Ticket> ticketList = new ArrayList<>();

    public boolean addTicket(Ticket ticket){
        return ticketList.add(ticket);
    }

    public Ticket findByIdTicket(Integer idTicket){
        for (Ticket ticket : ticketList) {
            if (ticket.getIdTicket() == idTicket) {
                return ticket;
            }
        }
        return new Ticket();
    }

    public boolean deleteTicket(Integer idTicket){
        Ticket ticket = findByIdTicket(idTicket);
        if (ticket.getIdTicket() == null) {
            return false;
        }
        return ticketList.remove(ticket);
    }

    public boolean editTicket(Ticket ticket){
        for (int i = 0; i < ticketList.size(); i++) {
            if (ticket.getIdTicket() == ticketList.get(i).getIdTicket()) {
                ticketList.set(i, ticket);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Ticket> getAll(){
        return ticketList;
    }
}//END OF THE CLASS
