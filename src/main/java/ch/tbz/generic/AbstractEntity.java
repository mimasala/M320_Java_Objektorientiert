package ch.tbz.generic;

import lombok.*;

import java.util.UUID;

@Getter@Setter@RequiredArgsConstructor
public abstract class AbstractEntity {
    private UUID id = UUID.randomUUID();
}
