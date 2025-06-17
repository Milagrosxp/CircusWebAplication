package cr.ac.ucr.demo.Repository;

import cr.ac.ucr.demo.Model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ShowRepository {
    //@Autowired
    ArrayList<Show> showList;

    //METHODS
    public boolean addShow(Show show){
        return showList.add(show);
    }

    public Show findByID(Integer id){
        for(int i=0; i < showList.size(); i++){
            if(showList.get(i).getIdShow() == id){
                return showList.get(i);
            }
        }
        return new Show();
    }

    public boolean deleteShow(Integer id){
        Show show = findByID(id);
        if(show.getIdShow()==null){
            return false;
        }
        return showList.remove(show);
    }

    public boolean editShow(Show show){
        for(int i=0; i<showList.size();i++){
            if(show.getIdShow()==showList.get(i).getIdShow()){
                showList.set(i, show);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Show> getAllShows(){
        return showList;
    }

}//END OF THE CLASS
