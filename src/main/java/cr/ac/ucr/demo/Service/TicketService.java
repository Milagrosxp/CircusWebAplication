package cr.ac.ucr.demo.Service;

import cr.ac.ucr.demo.Model.Ticket;
import cr.ac.ucr.demo.Repository.ITicketRepository;
import cr.ac.ucr.demo.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    ITicketRepository ticketRepository;

    //METHODS
    public Ticket addTicket(Ticket ticket){
        return this.ticketRepository.save(ticket);
    }

    public Optional<Ticket> findByIdTicket(Integer idTicket){
        return this.ticketRepository.findById(idTicket);
    }

    public Ticket editTicket(Ticket ticket){
        this.ticketRepository.deleteById(ticket.getIdTicket());
        return this.ticketRepository.save(ticket);
    }

    public void deleteTicket(Integer idTicket){this.ticketRepository.deleteById(idTicket);
    }

    public List<Ticket> getAll(){
        return this.ticketRepository.findAll();
    }
    public List<Ticket> findByUserId(Integer id){
        List<Ticket> listaTicket = new ArrayList<>();
        for(Ticket ticket: this.getAll()){
            if(ticket.getUser().getIdUser()==id){
                listaTicket.add(ticket);
            }
        }
        return listaTicket;
    }
}//END OF THE CLASS
