package cr.ac.ucr.demo.Repository;

import cr.ac.ucr.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
