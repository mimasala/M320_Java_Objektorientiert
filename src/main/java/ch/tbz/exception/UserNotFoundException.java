package ch.tbz.exception;

import javassist.NotFoundException;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserNotFoundException extends NotFoundException {
    private String username;

    public UserNotFoundException(String message, String username) {
        super(message + " " + username);
        this.username = username;
    }
}
