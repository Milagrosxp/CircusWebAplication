package cr.ac.ucr.demo.Controller;

import cr.ac.ucr.demo.Model.Manager;
import cr.ac.ucr.demo.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
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

}//END OF THE CLASS
