package cr.ac.ucr.demo.Service;

import cr.ac.ucr.demo.Model.Manager;
import cr.ac.ucr.demo.Repository.IManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    IManagerRepository managerRepository;

    //METHODS
    public Optional<Manager> findByID(Integer id){
        return this.managerRepository.findById(id);
    }

    public List<Manager> getAll(){
        return this.managerRepository.findAll();
    }

}//END OF THE CLASS
