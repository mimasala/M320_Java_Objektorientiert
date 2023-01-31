package ch.tbz.generic;

import lombok.*;

import java.util.UUID;
/**
 * Abstract Entity
 * @author mytal
 * @version 1.0.0
 */
@Getter@Setter@RequiredArgsConstructor
public abstract class AbstractEntity {
    private UUID id = UUID.randomUUID();
}
