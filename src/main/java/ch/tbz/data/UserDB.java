package ch.tbz.data;

import ch.tbz.entities.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB extends ArrayList<User> {
    public UserDB() {
        super();
    }

    public UserDB(List<User> users) {
        super(users);
    }
}
