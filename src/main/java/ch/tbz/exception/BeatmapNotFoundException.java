package ch.tbz.exception;

import javassist.NotFoundException;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BeatmapNotFoundException extends NotFoundException {
    private String beatmapName;
    public BeatmapNotFoundException(String message, String beatmapName) {
        super(message + " " + beatmapName);
        this.beatmapName = beatmapName;
    }
}
