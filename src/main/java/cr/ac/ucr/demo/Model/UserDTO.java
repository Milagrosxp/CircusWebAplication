package cr.ac.ucr.demo.Model;

public class UserDTO {
    private Integer idUser;
    private String name;
    private String telephone;
    // no incluimos password ni lista de tickets para no exponer ni complicar la serialización

    // Constructor vacío
    public UserDTO() {}

    // Constructor con parámetros (opcional)
    public UserDTO(Integer idUser, String name, String telephone) {
        this.idUser = idUser;
        this.name = name;
        this.telephone = telephone;
    }

    // Getters y setters
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
}
