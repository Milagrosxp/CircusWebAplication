package cr.ac.ucr.demo.Service;

import cr.ac.ucr.demo.Model.Show;
import cr.ac.ucr.demo.Repository.IShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    IShowRepository showRepository;

    //METHODS
    public Show addShow(Show show){
        return this.showRepository.save(show);
    }

    public Optional<Show> findByIdShow(Integer id) {

        return showRepository.findById(id);
    }


    public boolean editShow(Show editShow){
        Optional<Show> show = this.findByIdShow(editShow.getIdShow());
        if(show.isEmpty()){
            return false;
        }
        this.showRepository.save(editShow);  // Cambiado para solo guardar
        return true;
    }



    public void deleteShow(Integer id){
        this.showRepository.deleteById(id);
    }

    public List<Show> getAll(){
        return this.showRepository.findAll();
    }

}//END OF THE CLASS
