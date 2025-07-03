package cr.ac.ucr.demo.Controller;

import cr.ac.ucr.demo.Model.User;
import cr.ac.ucr.demo.Service.UserService;
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
@CrossOrigin(origins = "*")
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@Validated @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }

        if(userService.findByIdUser(user.getIdUser()).isPresent()){
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
        Optional<User> user = userService.findByIdUser(id);
        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        Optional<User> userOptional = this.userService.findByIdUser(id);
        if(!userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No User is using this ID.");
        }
        this.userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
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
        Optional<User> userOptional = this.userService.findByIdUser(user.getIdUser());
        if(!userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        userService.editUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@PathVariable Integer id, @PathVariable String password){
        if(this.userService.userExist(id, password)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }
}
