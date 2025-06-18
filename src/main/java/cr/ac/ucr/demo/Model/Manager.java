package cr.ac.ucr.demo.Model;

public class Manager {
    private Integer idManager;
    private String name;
    private String telephone;
    private String password;

    //CONSTRUCTOR METHOD
    public Manager() {
        this.idManager = 0;
        this.name = "Ghost";
        this.telephone = "00-00";
        this.password = "0000";
    }

    public Manager(Integer idManager, String name, String telephone, String password) {
        this.idManager = idManager;
        this.name = name;
        this.telephone = telephone;
        this.password = password;
    }

    //SET & GET METHODS
    public Integer getIdManager() {
        return idManager;
    }

    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}//END OF THE CLASS
