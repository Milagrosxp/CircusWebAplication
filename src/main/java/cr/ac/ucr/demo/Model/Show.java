package cr.ac.ucr.demo.Model;


import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_show")
public class Show {

    @Column(name = "idShow")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idShow;
    private String name;
    private Integer amountOfSeats;
    private Integer generalTicket;
    private Double generalPrice;
    private Integer plateaTicket;
    private Double plateaPrice;
    private Integer vipTicket;
    private Double vipPrice;
    private Date showTime;
    private String location;
    @Column(length = 1000)
    private String image;
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketList;

    //CONSTRUCTOR METHOD
    public Show() {
    }

    public Show(Integer idShow, String name, Integer amountOfSeats, Integer generalTicket, Double generalPrice, Integer plateaTicket, Double plateaPrice, Integer vipTicket, Double vipPrice, Date showTime, String location, String image) {
        this.idShow = idShow;
        this.name = name;
        this.amountOfSeats = amountOfSeats;
        this.generalTicket = generalTicket;
        this.generalPrice = generalPrice;
        this.plateaTicket = plateaTicket;
        this.plateaPrice = plateaPrice;
        this.vipTicket = vipTicket;
        this.vipPrice = vipPrice;
        this.showTime = showTime;
        this.location = location;
        this.image = image;
    }

    //SET & GET METHODS
    public Integer getIdShow() { return idShow; }

    public void setIdShow(Integer idShow) { this.idShow = idShow; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAmountOfSeats() { return amountOfSeats; }

    public void setAmountOfSeats(Integer amountOfSeats) { this.amountOfSeats = amountOfSeats; }

    public Integer getGeneralTicket() { return generalTicket; }

    public void setGeneralTicket(Integer generalTicket) { this.generalTicket = generalTicket; }

    public Double getGeneralPrice() { return generalPrice; }

    public void setGeneralPrice(Double generalPrice) { this.generalPrice = generalPrice; }

    public Integer getPlateaTicket() { return plateaTicket; }

    public void setPlateaTicket(Integer plateaTicket) { this.plateaTicket = plateaTicket; }

    public Double getPlateaPrice() { return plateaPrice; }

    public void setPlateaPrice(Double plateaPrice) { this.plateaPrice = plateaPrice; }

    public Integer getVipTicket() { return vipTicket; }

    public void setVipTicket(Integer vipTicket) { this.vipTicket = vipTicket; }

    public Double getVipPrice() { return vipPrice; }

    public void setVipPrice(Double vipPrice) { this.vipPrice = vipPrice; }

    public Date getShowTime() { return showTime; }

    public void setShowTime(Date showTime) { this.showTime = showTime; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}//END OF THE CLASS

