package ch.tbz.user;

import ch.tbz.exception.UserNotFoundException;
import ch.tbz.helpers.FakerService;
import ch.tbz.log.OsuLog;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter@Setter
public class UserService {
    private OsuLog log = new OsuLog();
    private List<User> userDB;
    public UserService() {
        this.userDB = FakerService.createUserDataBase(100);
    }
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
    public void printUser(List<User> users) {
        log.info(new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(users));
    }
}
