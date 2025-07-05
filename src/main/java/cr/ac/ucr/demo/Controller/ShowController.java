package cr.ac.ucr.demo.Controller;

import cr.ac.ucr.demo.Model.Show;
import cr.ac.ucr.demo.Model.User;
import cr.ac.ucr.demo.Service.ShowService;
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
@RequestMapping("api/shows")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping
    public ResponseEntity<?> addShow(@Validated @RequestBody Show show, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }

        if(showService.findByIdShow(show.getIdShow()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This ID is registered");
        }

        return ResponseEntity.status(HttpStatus.OK).body(showService.addShow(show));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        if(showService.getAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No shows registered yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(showService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShow(@PathVariable Integer id){
        Optional<Show> show = showService.findByIdShow(id);
        if(!show.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Show not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(show);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShow(@PathVariable Integer id){
        Optional<Show> showOptional = this.showService.findByIdShow(id);
        if(!showOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No show is using this ID.");
        }
        this.showService.deleteShow(id);
        return ResponseEntity.status(HttpStatus.OK).body("Show deleted successfully.");
    }

    @PutMapping
    public ResponseEntity<?> updateShow(@Validated @RequestBody Show show, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }
        Optional<Show> showOptional = this.showService.findByIdShow(show.getIdShow());
        if(!showOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Show not found");
        }
        showService.editShow(show);
        return ResponseEntity.status(HttpStatus.OK).body("Show updated successfully.");
    }
}
