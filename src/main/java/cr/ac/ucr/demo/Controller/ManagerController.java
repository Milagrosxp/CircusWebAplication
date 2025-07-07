package cr.ac.ucr.demo.Controller;

import cr.ac.ucr.demo.Model.Manager;
import cr.ac.ucr.demo.Model.User;
import cr.ac.ucr.demo.Service.ManagerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:63342", allowCredentials = "true")
@RequestMapping("/api/managers")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    //METHODS
    @GetMapping("/{id}")
    public ResponseEntity<?> findByID(@PathVariable Integer id){
        Optional<Manager> manager = this.managerService.findByID(id);
        if(!manager.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manager not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(manager);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        if(managerService.getAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No managers registered yet.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(managerService.getAll());
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody Manager manager, HttpSession session){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
        /*
        if(this.managerService.userExist(manager.getIdManager(), manager.getPassword())){
            session.setAttribute("activeSession", this.managerService.findByID(manager.getIdManager()).get());

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
    */
    }

}//END OF THE CLASS
