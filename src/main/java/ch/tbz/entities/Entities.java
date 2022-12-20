package ch.tbz.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
public abstract class Entities {
    private LocalDateTime creationDate = LocalDateTime.now();
}
