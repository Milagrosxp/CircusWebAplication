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
        Manager managerFind = this.managerService.findByID(id);
        if(managerFind == null || managerFind.getIdManager() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El manager con el ID "+id+" no se encuentra registrado.");
        }
        return ResponseEntity.ok(managerFind);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        ArrayList<Manager> listUser = this.managerService.getAll();
        if(listUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No existen managers registrados");
        }
        return ResponseEntity.ok(listUser);
    }

}//END OF THE CLASS
