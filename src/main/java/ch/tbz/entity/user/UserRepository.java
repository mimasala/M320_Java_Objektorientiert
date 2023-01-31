package ch.tbz.entity.user;

import ch.tbz.generic.AbstractEntityRepository;
import ch.tbz.util.API;

/**
 * User Repository
 * @author mytal
 * @version 1.0.0
 */
public class UserRepository extends AbstractEntityRepository<User> {
    public UserRepository(API api) {
        super(api);
    }
}
