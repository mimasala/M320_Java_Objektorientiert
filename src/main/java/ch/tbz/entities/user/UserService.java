package ch.tbz.entities.user;

import ch.tbz.entities.CrudOperations;
import ch.tbz.exception.UserNotFoundException;
import ch.tbz.log.OsuLog;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static ch.tbz.Program.userDB;
@Getter@Setter@NoArgsConstructor
public class UserService implements CrudOperations<User, Integer> {
    public List<User> getByName(String name) throws UserNotFoundException {
        List<User> filteredUserDB = getAll()
                .stream()
                .filter(user -> user.getUsername().contains(name))
                .toList();
        if (filteredUserDB.isEmpty()) {
            throw new UserNotFoundException("User not found: ", name);
        }
        return filteredUserDB;
    }
    public List<User> getAllUsers() {
        return userDB;
    }
    public void printUsers(List<User> users) {
        OsuLog.info(new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(users));
    }
// CRUD Operations
    @Override
    public List<User> getAll() {
        return userDB;
    }

    @Override
    public User get(Integer integer) {
        return userDB.get(integer);
    }

    @Override
    public void save(User user) {
        userDB.add(user);
    }
    @Override
    public void saveAll(List<User> user) {
        userDB.addAll(user);
    }

    @Override
    public void update(Integer id, User user) {
        userDB.set(id, user);
    }

    @Override
    public void delete(Integer id) {
        userDB.remove(userDB.get(id));
    }
}
