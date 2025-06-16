package cr.ac.ucr.demo.Controller;

import cr.ac.ucr.demo.Model.User;
import cr.ac.ucr.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@Validated @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField() , error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }
        if(userService.findById(user.getIdUser())!=null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This ID is registered");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(user));
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        if(userService.getAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No users registered yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id){
        if(userService.findById(id).getIdUser()==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        if(userService.deleteUser(id)){
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userService.deleteUser(id));
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Validated @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }
        if(userService.findById(user.getIdUser()).getIdUser()==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.editUser(user));
    }
}
