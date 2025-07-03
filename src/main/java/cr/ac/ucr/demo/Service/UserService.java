package cr.ac.ucr.demo.Service;

import cr.ac.ucr.demo.Model.User;
import cr.ac.ucr.demo.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    //METHODS
    public User addUser(User user){
        return this.userRepository.save(user);
    }

    public Optional<User> findByIdUser(Integer id) {

        return userRepository.findById(id);
    }


    public boolean editUser(User editUser){
        Optional<User> user = this.findByIdUser(editUser.getIdUser());
        if(user.isEmpty()){
            return false;
        }
        this.deleteUser(editUser.getIdUser());
        this.addUser(editUser);
        return true;

    }

    public void deleteUser(Integer id){
        this.userRepository.deleteById(id);
    }

    public List<User> getAll(){
        return this.userRepository.findAll();
    }

    public boolean userExist(Integer id, String password){
        for(User user:this.getAll()){
            if(user.getIdUser()==id && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}//END OF THE CLASS
