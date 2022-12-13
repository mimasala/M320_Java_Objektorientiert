package ch.tbz.data;

import ch.tbz.entities.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter@Setter@AllArgsConstructor
public class UserDB {
    private ArrayList<User> users;
}
