package cr.ac.ucr.demo.Controller;

import cr.ac.ucr.demo.Model.Manager;
import cr.ac.ucr.demo.Repository.ManagerRepository;
import cr.ac.ucr.demo.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    //METHODS
    @GetMapping("/{id}")
    public ResponseEntity<?> findByID(@PathVariable Integer id){
        if(managerService.findByID(id).getIdManager() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manager not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(managerService.findByID(id));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        if(managerService.getAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There aren't managers registered in the system.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(managerService.getAll());
    }

}//END OF THE CLASS
