package cr.ac.ucr.demo.Service;

import cr.ac.ucr.demo.Model.User;
import cr.ac.ucr.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //METHODS
    public boolean addUser(User user){
        return this.userRepository.addUser(user);
    }

    public User findByIdUser(Integer id) {
        return userRepository.findByIdUser(id);
    }


    public boolean editUser(User user){
        return this.userRepository.editUser(user);
    }

    public boolean deleteUser(Integer id){
        return this.userRepository.deleteUser(id);
    }

    public ArrayList<User> getAll(){
        return this.userRepository.getAll();
    }
}//END OF THE CLASS
