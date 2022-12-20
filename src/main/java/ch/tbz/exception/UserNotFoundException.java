package ch.tbz.exception;

import javassist.NotFoundException;
import lombok.Getter;
import lombok.Setter;
/**
 * exception, for when a user is not found
 * @author mytal, joelsow
 * @version 1.0.0
 */
@Getter@Setter
public class UserNotFoundException extends NotFoundException {
    private String username;

    public UserNotFoundException(String message, String username) {
        super(message + " " + username);
        this.username = username;
    }
}
