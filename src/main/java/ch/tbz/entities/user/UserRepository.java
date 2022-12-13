package ch.tbz.entities.user;

import ch.tbz.entities.CrudOperations;
import static ch.tbz.Program.*;

import java.util.List;

public class UserRepository implements CrudOperations<User, Integer> {

    @Override
    public List<User> getAll() {
        return userDB.getUsers();
    }

    @Override
    public User get(Integer integer) {
        return userDB.getUsers().get(integer);
    }

    @Override
    public void save(User user) {
        userDB.getUsers().add(user);
    }

    @Override
    public void update(User user) {
        userDB.getUsers().set(user.getUserId(), user);
    }

    @Override
    public void delete(Integer integer) {
        userDB.getUsers().remove(integer);
    }
}
