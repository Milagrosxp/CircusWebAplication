package cr.ac.ucr.demo.Repository;

import cr.ac.ucr.demo.Model.Show;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ShowRepository {
    private final ArrayList<Show> showList = new ArrayList<>();

    public boolean addShow(Show show) {
        return showList.add(show);
    }

    public ArrayList<Show> getAllShow() {
        return showList;
    }

    public Show findByIdShow(Integer idShow) {
        for (Show show : showList) {
            if (show.getIdShow().equals(idShow)) {
                return show;
            }
        }
        return null;
    }

    public boolean deleteShow(Integer idShow) {
        Show show = findByIdShow(idShow);
        if (show == null) return false;
        return showList.remove(show);
    }

    public boolean editShow(Show show) {
        for (int i = 0; i < showList.size(); i++) {
            if (showList.get(i).getIdShow().equals(show.getIdShow())) {
                showList.set(i, show);
                return true;
            }
        }
        return false;
    }

}//END OF THE CLASS
