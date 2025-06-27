package cr.ac.ucr.demo.Model;


import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    private Integer idUser;
    private String name;
    private String telephone;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Ticket> ticketList;

    //CONSTRUCTOR METHODS
    public User(Integer idUser, String password, String telephone, String name) {
        this.idUser = idUser;
        this.password = password;
        this.telephone = telephone;
        this.name = name;
    }

    public User() {
    }

    //SET & GET METHODS
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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
