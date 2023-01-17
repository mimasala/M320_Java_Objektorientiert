package ch.tbz.entities;

import com.google.gson.GsonBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter@Setter
public abstract class Entities implements Comparable<Entities> {
    @Getter(AccessLevel.NONE)@Setter(AccessLevel.NONE)
    private transient LocalDateTime creationDate = LocalDateTime.now();
    public String getFormattedDateTime() {
        return DateTimeFormatter
                .ofPattern("dd.MM.yyyy, HH:mm:ss")
                .format(this.creationDate);
    }
    @Override
    public String toString() {
        return "-------------------------------\ncreated at: " +
                getFormattedDateTime() + "\n" +
                new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

}
