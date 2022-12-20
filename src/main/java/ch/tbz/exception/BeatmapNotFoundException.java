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
public class BeatmapNotFoundException extends NotFoundException {
    private String beatmapName;
    public BeatmapNotFoundException(String message, String beatmapName) {
        super(message + " " + beatmapName);
        this.beatmapName = beatmapName;
    }
}
