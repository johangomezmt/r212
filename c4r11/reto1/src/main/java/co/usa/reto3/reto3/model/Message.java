package co.usa.reto3.reto3.model;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name="MESSAGE")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMessage;
    private String messageText;



    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "cabin")
    private Cabin cabin;

    public Integer getIdMessage() {
        return IdMessage;
    }

    public void setIdMessage(Integer idMessage) {
        IdMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }
}
