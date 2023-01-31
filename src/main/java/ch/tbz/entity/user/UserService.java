package ch.tbz.entity.user;

import ch.tbz.generic.AbstractEntityService;

import java.lang.reflect.Type;

/**
 * User Service
 * @author mytal
 * @version 1.0.0
 */
public class UserService extends AbstractEntityService<User> {
    public UserService(UserRepository repository, Type type) {
        super(repository, type);
    }
}
