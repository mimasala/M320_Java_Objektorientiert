package ch.tbz.entities.user;

import ch.tbz.entities.CrudOperations;
import ch.tbz.log.OsuLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ch.tbz.Program.userDB;
@Getter@Setter@NoArgsConstructor
public class UserService implements CrudOperations<User, Integer> {
    public String getByName(String name) {
        return userListToPrettyJsonArray(
                getAll()
                .stream()
                .filter(user -> user.getUsername().contains(name))
                .toList());
    }
    public void printUsers(List<User> users) {
        OsuLog.info(new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(users));
    }
    public User userFromJsonString(String json){
        return new GsonBuilder().create().fromJson(json, User.class);
    }
    public void saveUserFromJsonString(String json){
        User user = userFromJsonString(json);
        userDB.add(user);
    }
    public void deleteUserByName(String string) {
        userDB.removeIf(user -> user.getUsername().contains(string));
    }
    private String userListToPrettyJsonArray(List<User> userList){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(userList);
    }
// CRUD Operations
    @Override
    public List<User> getAll() {
        return userDB;
    }

    @Override
    public User get(Integer integer) {
        try {
            return userDB.get(integer);
        } catch (IndexOutOfBoundsException e) {
            OsuLog.error("User with id " + integer + " not found");
            return null;
        }
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
