package cr.ac.ucr.demo.Repository;

import cr.ac.ucr.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class UserRepository {
    @Autowired
    ArrayList<User> userList;

    public boolean add(User user){
        return userList.add(user);
    }

    public User findById(Integer id){
        for(User user:userList){
            if(user.getIdUser()==id){
                return user;
            }
        }
        return new User();
    }
    public boolean deleteUser(Integer id){
        User user = findById(id);
        if(user.getIdUser()==null){
            return false;
        }
        return userList.remove(user);
    }



}
