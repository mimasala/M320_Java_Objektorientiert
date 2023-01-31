package ch.tbz.entity.user;

import ch.tbz.generic.AbstractEntityService;

import java.lang.reflect.Type;

public class UserService extends AbstractEntityService<User> {
    public UserService(UserRepository repository, Type type) {
        super(repository, type);
    }
}
