package co.usa.reto3.reto3.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import co.usa.reto3.reto3.model.Category;

@Entity
@Table(name="Cabin")
public class Cabin implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String BRAND;
    private String ROOMS;
    private String NAME;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    public List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    public List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public String getROOMS() {
        return ROOMS;
    }

    public void setROOMS(String ROOMS) {
        this.ROOMS = ROOMS;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
