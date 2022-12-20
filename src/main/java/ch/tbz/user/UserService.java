package ch.tbz.user;

import ch.tbz.exception.UserNotFoundException;
import ch.tbz.helpers.FakerService;
import ch.tbz.log.OsuLog;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author mytal, joelsow
 * @version 1.0.0
 */
@Getter@Setter
public class UserService {
    private OsuLog log = new OsuLog();
    private List<User> userDB;
    public UserService() {
        this.userDB = FakerService.createUserDataBase(100);
    }

    /**
     * @param name name of the user that needs to be found
     * @return the found user
     * @throws UserNotFoundException user is not found
     */
    public List<User> findUser(String name) throws UserNotFoundException {
        List<User> list = userDB
                .stream()
                .filter(user -> user.getUsername().contains(name))
                .toList();
        if (list.isEmpty()) {
            throw new UserNotFoundException("User not found: ", name);
        }
        return list;
    }

    /**
     * @param users List of users to pretty print
     */
    public void printUser(List<User> users) {
        log.info(new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(users));
    }
}
