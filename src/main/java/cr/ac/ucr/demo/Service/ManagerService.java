package cr.ac.ucr.demo.Service;

import cr.ac.ucr.demo.Model.Manager;
import cr.ac.ucr.demo.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    //METHODS
    public Manager findByID(Integer id){
        return this.managerRepository.findByID(id);
    }

    public ArrayList<Manager> getAll(){
        return this.managerRepository.getAllManagers();
    }

}//END OF THE CLASS
