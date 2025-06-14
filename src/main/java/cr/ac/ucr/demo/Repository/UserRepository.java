package cr.ac.ucr.demo.Repository;

import cr.ac.ucr.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
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

    public boolean editUser(User user){
        for(int i=0; i<userList.size();i++){
            if(user.getIdUser()==userList.get(i).getIdUser()){
                userList.set(i, user);
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getAll(){
        return userList;
    }
}
