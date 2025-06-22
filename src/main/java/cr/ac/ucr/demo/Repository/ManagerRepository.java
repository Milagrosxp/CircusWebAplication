package cr.ac.ucr.demo.Repository;

import cr.ac.ucr.demo.Model.Manager;
import cr.ac.ucr.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ManagerRepository {
    ArrayList<Manager> managerList = new ArrayList<>();;

    //CONSTRUCTOR METHOD
    public ManagerRepository(){
        System.out.println("Precargando managers...");
        managerList.add(new Manager(584, "Daylin", "1234-5678", "pass101"));
        managerList.add(new Manager(662, "Darian", "8765-4321", "pass202"));
        managerList.add(new Manager(660, "Joseph", "1827-3645", "pass303"));
        managerList.add(new Manager(841, "Kevin", "5463-7281", "pass404"));
        managerList.add(new Manager(300, "Aaron", "1029-3847", "pass505"));
    }

    //METHODS
    public Manager findByID(Integer id){
        for (Manager manager : managerList) {
            if (manager.getIdManager().equals(id)) {
                return manager;
            }
        }
        return null;
    }

    public ArrayList<Manager> getAllManagers(){
        return managerList;
    }

}//END OF THE CLASS
