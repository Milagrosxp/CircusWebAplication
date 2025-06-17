package cr.ac.ucr.demo.Controller;

import cr.ac.ucr.demo.Model.Show;
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

@RestController
@RequestMapping("api/shows")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping
    public ResponseEntity<?> addShow(@Validated @RequestBody Show show, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField() , error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }
        if(showService.findById(show.getIdShow())!=null){
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
        if(showService.findById(id).getIdShow()==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Show not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(showService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShow(@PathVariable Integer id){
        if(showService.deleteShow(id)){
            return ResponseEntity.status(HttpStatus.OK).body(showService.deleteShow(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(showService.deleteShow(id));
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
        if(showService.findById(show.getIdShow()).getIdShow()==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Show not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(showService.editShow(show));
    }

}
