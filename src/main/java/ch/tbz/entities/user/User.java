package ch.tbz.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@AllArgsConstructor@ToString
public class User {
    private String username;
    private String password;
    private String email;
    private String country;
    private String rank;
    private String joinDate;
    private String playTime;
    private String totalScore;
}
