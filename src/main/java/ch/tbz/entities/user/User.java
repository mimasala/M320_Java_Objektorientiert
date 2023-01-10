package ch.tbz.entities.user;

import ch.tbz.entities.Entities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}
