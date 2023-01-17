package ch.tbz.entities.user;

import ch.tbz.data.UserDB;
import ch.tbz.entities.BaseOperations;
import ch.tbz.entities.CrudOperations;
import ch.tbz.log.OsuLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static ch.tbz.Program.userDB;
@Getter@Setter@NoArgsConstructor
public class UserService implements CrudOperations<User, Integer>, BaseOperations {
    public String getByName(String name) {
        return userListToPrettyJsonArray(
                getAll()
                .stream()
                .filter(user -> user.getUsername().contains(name))
                .toList());
    }
    public User getUserObjByName(String name){
        return getAll()
                .stream()
                .filter(user -> user.getUsername().contains(name))
                .toList().get(0);
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

    public void insertionSortByName(){
        for (int i = 1; i < userDB.size(); i++) {
            User key = userDB.get(i);
            int j = i - 1;
            while (j >= 0 && userDB.get(j).getUsername().compareTo(key.getUsername()) > 0) {
                userDB.set(j + 1, userDB.get(j));
                j = j - 1;
            }
            userDB.set(j + 1, key);
        }
    }

    public void insertionSortByNameDesc() {
        insertionSortByName();
        Collections.reverse(userDB);
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

    @Override
    public void sortList() {
        Collections.sort(userDB);
    }
}
