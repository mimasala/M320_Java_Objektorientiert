package ch.tbz.entity.user;

import ch.tbz.generic.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User extends AbstractEntity {
    private String username;
    private String country;
    private String country_code;
    private String join_date;
    private String playstyle;
}
