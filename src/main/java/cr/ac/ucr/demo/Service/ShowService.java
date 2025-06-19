package cr.ac.ucr.demo.Service;

import cr.ac.ucr.demo.Model.Show;
import cr.ac.ucr.demo.Model.User;
import cr.ac.ucr.demo.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    //METHODS
    public boolean addShow(Show show){ return this.showRepository.addShow(show); }

    public Show findById(Integer id){ return this.showRepository.findByIdShow(id); }

    public boolean editShow(Show show){ return this.showRepository.editShow(show); }

    public boolean deleteShow(Integer id){ return this.showRepository.deleteShow(id); }

    public ArrayList<Show> getAll(){ return this.showRepository.getAllShow(); }

}//END OF THE CLASS
