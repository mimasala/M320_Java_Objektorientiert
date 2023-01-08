package ch.tbz.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter@Setter
public abstract class Entities {
    @Getter(AccessLevel.NONE)
    protected LocalDateTime creationDate = LocalDateTime.now();
    public String getFormattedDateTime() {
        return DateTimeFormatter
                .ofPattern("dd.MM.yyyy, HH:mm:ss")
                .format(this.creationDate);
    }
}
