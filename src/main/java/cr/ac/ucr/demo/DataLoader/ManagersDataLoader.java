package cr.ac.ucr.demo.DataLoader;

import cr.ac.ucr.demo.Model.Manager;
import cr.ac.ucr.demo.Repository.IManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ManagersDataLoader implements CommandLineRunner{
    @Autowired
    private IManagerRepository managerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (managerRepository.count() == 0) {
            System.out.println("Preloading managers into the data-base...");
            managerRepository.save(new Manager(584, "Daylin", "1234-5678", "pass101"));
            managerRepository.save(new Manager(662, "Darian", "8765-4321", "pass202"));
            managerRepository.save(new Manager(660, "Joseph", "1827-3645", "pass303"));
            managerRepository.save(new Manager(841, "Kevin", "5463-7281", "pass404"));
            managerRepository.save(new Manager(300, "Aaron", "1029-3847", "pass505"));
        }
    }

}//END OF THE CLASS
