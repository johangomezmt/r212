package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.model.Message;
import co.usa.reto3.reto3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();

    }
    public Optional <Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save (Message c) {
        if(c.getIdMessage()==null) {
            return messageRepository.save(c);
        }
        else {
            Optional<Message> aux=messageRepository.getMessage(c.getIdMessage());
            if(aux.isEmpty()) {
                return messageRepository.save(c);
            }else {
                return c;
            }
        }

    }
    public Message update(Message a){
        if(a.getIdMessage()!=null){
            Optional<Message>d=messageRepository.getMessage(a.getIdMessage());
            if(!d.isEmpty()){
                if (a.getMessageText()!=null){
                    d.get().setMessageText(a.getMessageText());
                }
                return messageRepository.save((d.get()));
            }
        }
        return a;
    }
    public boolean deleteMessage(int id){
        Optional<Message> c=getMessage(id);
        if(!c.isEmpty()){
            messageRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
