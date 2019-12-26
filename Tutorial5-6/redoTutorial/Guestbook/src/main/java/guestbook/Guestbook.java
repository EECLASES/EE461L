package guestbook;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Guestbook {
    @Id long id;
    String name;
    
    static {

        ObjectifyService.register(Greeting.class);

    }

    public Guestbook(String name) {
        this.name = name;
    }
}