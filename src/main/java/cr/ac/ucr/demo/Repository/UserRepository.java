package cr.ac.ucr.demo.Repository;

import cr.ac.ucr.demo.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository {

    private final ArrayList<User> userList = new ArrayList<>();

    public boolean addUser(User user) {
        return userList.add(user);
    }

    public ArrayList<User> getAll() {
        return userList;
    }

    public User findByIdUser(Integer idUser) {
        for (User user : userList) {
            if (user.getIdUser().equals(idUser)) {
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(Integer idUser) {
        User user = findByIdUser(idUser);
        if (user == null) return false;
        return userList.remove(user);
    }

    public boolean editUser(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getIdUser().equals(user.getIdUser())) {
                userList.set(i, user);
                return true;
            }
        }
        return false;
    }
}//END OF THE CLASS
