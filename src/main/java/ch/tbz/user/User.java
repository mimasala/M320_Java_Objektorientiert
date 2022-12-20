package ch.tbz.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * user entity class
 * @author mytal, joelsow
 * @version 1.0.0
 */
@Getter@Setter@AllArgsConstructor@ToString
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String country;
    private String rank;
    private String joinDate;
    private String playTime;
    private String totalScore;
}
