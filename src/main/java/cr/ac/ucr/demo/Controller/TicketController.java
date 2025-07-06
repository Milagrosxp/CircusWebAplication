package cr.ac.ucr.demo.Controller;

import cr.ac.ucr.demo.Model.Ticket;
import cr.ac.ucr.demo.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<?> addTicket(@Validated @RequestBody Ticket ticket, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }

        if(ticketService.findByIdTicket(ticket.getIdTicket()).get().getIdTicket() != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This Ticket is already registered");
        }

        return ResponseEntity.status(HttpStatus.OK).body(ticketService.addTicket(ticket));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        if(ticketService.getAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No tickets registered yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicket(@PathVariable Integer id){
        if(ticketService.findByIdTicket(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.findByIdTicket(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Integer id){
        Optional<Ticket> optionalTicket =  this.ticketService.findByIdTicket(id);
        if(optionalTicket.isPresent()){
            this.ticketService.deleteTicket(id);
            return ResponseEntity.status(HttpStatus.OK).body("Ticket eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el ticket");
    }

    @PutMapping
    public ResponseEntity<?> updateTicket(@Validated @RequestBody Ticket ticket, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }

        if(ticketService.findByIdTicket(ticket.getIdTicket()) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(ticketService.editTicket(ticket));
    }
}//END OF THE CLASS
