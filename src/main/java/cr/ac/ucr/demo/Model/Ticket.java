package cr.ac.ucr.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name="tb_ticket")
public class Ticket {
    @Id
    private Integer idTicket;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "idShow")
    private Show show;
    private String category;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    //CONSTRUCTOR
    public Ticket() {
    }

    public Ticket(Integer idTicket, Double price, Show show, String category) {
        this.idTicket = idTicket;
        this.price = price;
        this.show = show;
        this.category = category;
    }

    //SET & GET METHODS
    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}//END OF THE CLASS

