package cr.ac.ucr.demo.Service;

import cr.ac.ucr.demo.Model.Ticket;
import cr.ac.ucr.demo.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    //METHODS
    public boolean addTicket(Ticket ticket){
        return this.ticketRepository.addTicket(ticket);
    }

    public Ticket findByIdTicket(Integer idTicket){
        return this.ticketRepository.findByIdTicket(idTicket);
    }

    public boolean editTicket(Ticket ticket){
        return this.ticketRepository.editTicket(ticket);
    }

    public boolean deleteTicket(Integer idTicket){
        return this.ticketRepository.deleteTicket(idTicket);
    }

    public ArrayList<Ticket> getAll(){
        return this.ticketRepository.getAll();
    }

}//END OF THE CLASS
