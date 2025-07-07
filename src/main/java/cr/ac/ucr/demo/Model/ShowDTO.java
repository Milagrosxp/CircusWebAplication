package cr.ac.ucr.demo.Model;

import java.util.Date;

public class ShowDTO {
    private Integer idShow;
    private String name;
    private String location;
    private Date showTime;  // o Date si quieres manejar fechas, y luego formatear en frontend
    private Integer amountOfSeats;
    private Integer generalTicket;
    private Double generalPrice;
    private Integer plateaTicket;
    private Double plateaPrice;
    private Integer vipTicket;
    private double vipPrice;
    private String image;

    public ShowDTO() {}

    public ShowDTO(Integer idShow, String name, String location, Date showTime, Integer amountOfSeats, String image) {
        this.idShow = idShow;
        this.name = name;
        this.location = location;
        this.showTime = showTime;
        this.amountOfSeats = amountOfSeats;
        this.image = image;
    }

    // Getters y setters
    public Integer getIdShow() {
        return idShow;
    }
    public void setIdShow(Integer idShow) {
        this.idShow = idShow;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Date getShowTime() {
        return showTime;
    }
    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }
    public Integer getAmountOfSeats() {
        return amountOfSeats;
    }
    public void setAmountOfSeats(Integer amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public Integer getGeneralTicket() {
        return generalTicket;
    }

    public void setGeneralTicket(Integer generalTicket) {
        this.generalTicket = generalTicket;
    }

    public Double getGeneralPrice() {
        return generalPrice;
    }

    public void setGeneralPrice(Double generalPrice) {
        this.generalPrice = generalPrice;
    }

    public Integer getPlateaTicket() {
        return plateaTicket;
    }

    public void setPlateaTicket(Integer plateaTicket) {
        this.plateaTicket = plateaTicket;
    }

    public Double getPlateaPrice() {
        return plateaPrice;
    }

    public void setPlateaPrice(Double plateaPrice) {
        this.plateaPrice = plateaPrice;
    }

    public Integer getVipTicket() {
        return vipTicket;
    }

    public void setVipTicket(Integer vipTicket) {
        this.vipTicket = vipTicket;
    }

    public double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public void convertToDTO(Show show){

        setShowTime(show.getShowTime());
        setGeneralTicket(show.getGeneralTicket());
        setGeneralPrice(show.getGeneralPrice());
        setPlateaTicket(show.getPlateaTicket());
        setPlateaPrice(show.getPlateaPrice());
        setVipTicket(show.getVipTicket());
        setVipPrice(show.getVipPrice());
        setLocation(show.getLocation());
        setName(show.getName());
        setAmountOfSeats(show.getAmountOfSeats());
        setImage(show.getImage());
    }
}
