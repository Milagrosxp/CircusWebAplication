package cr.ac.ucr.demo.Repository;

import cr.ac.ucr.demo.Model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ManagerRepository {
    ArrayList<Manager> managerList;

    //METHODS
    public Manager findByID(Integer id){
        for(int i=0; i < managerList.size(); i++){
            if(managerList.get(i).getIdManager() == id){
                return managerList.get(i);
            }
        }
        return new Manager();
    }

    public ArrayList<Manager> getAllManagers(){
        return managerList;
    }

}//END OF THE CLASS
