package ch.tbz.entities.user;

import ch.tbz.entities.Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class User extends Entities {
    private String username;
    private String password;
    private String email;
    private String country;
    private String rank;
    private String joinDate;
    private String playTime;
    private String totalScore;

    @Override
    public int compareTo(Entities o) {
        return this.getFormattedDateTime().compareTo(o.getFormattedDateTime());
    }
}
