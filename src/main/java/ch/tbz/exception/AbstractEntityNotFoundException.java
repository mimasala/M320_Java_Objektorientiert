package ch.tbz.exception;

import java.io.IOException;

/**
 * Abstract Entity Not Found Exception
 * @author mytal
 * @version 1.0.0
 */
public class AbstractEntityNotFoundException extends IOException {
    public AbstractEntityNotFoundException(String message) {
        super(message);
    }
}
