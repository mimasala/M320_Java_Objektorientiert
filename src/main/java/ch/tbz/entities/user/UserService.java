package ch.tbz.entities.user;

import ch.tbz.exception.UserNotFoundException;
import ch.tbz.log.OsuLog;
import static ch.tbz.Program.*;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter@Setter@NoArgsConstructor
public class UserService{
    private UserRepository userRepository = new UserRepository();
    public List<User> getByName(String name) throws UserNotFoundException {
        List<User> filteredUserDB = userRepository.getAll()
                .stream()
                .filter(user -> user.getUsername().contains(name))
                .toList();
        if (filteredUserDB.isEmpty()) {
            throw new UserNotFoundException("User not found: ", name);
        }
        return filteredUserDB;
    }
    public List<User> getAllUsers() {
        return userDB.getUsers();
    }
    public void printUsers(List<User> users) {
        OsuLog.info(new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(users));
    }
}
