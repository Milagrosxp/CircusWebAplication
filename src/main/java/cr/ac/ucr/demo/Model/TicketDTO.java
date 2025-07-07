package cr.ac.ucr.demo.Model;

public class TicketDTO {
    private Integer idTicket;
    private Double price;
    private String category;
    private Integer userId;
    private Integer showId;
    private String showName;

    // Constructor vacío (requerido para Jackson)
    public TicketDTO() {}

    // Constructor completo
    public TicketDTO(Integer idTicket, Double price, String category, Integer userId, Integer showId) {
        this.idTicket = idTicket;
        this.price = price;
        this.category = category;
        this.userId = userId;
        this.showId = showId;
    }

    // Getters y Setters
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public void converToDTO(Ticket ticket){
        setIdTicket(ticket.getIdTicket());
        setCategory(ticket.getCategory());
        setPrice(ticket.getPrice());
        setUserId(ticket.getUser().getIdUser());
        setShowId(ticket.getShow().getIdShow());
        setShowName(ticket.getShow().getName());
    }
}
