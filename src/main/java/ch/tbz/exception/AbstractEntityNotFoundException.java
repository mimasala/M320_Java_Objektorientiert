package ch.tbz.exception;

import java.io.IOException;

public class AbstractEntityNotFoundException extends IOException {
    public AbstractEntityNotFoundException(String message) {
        super(message);
    }
}
