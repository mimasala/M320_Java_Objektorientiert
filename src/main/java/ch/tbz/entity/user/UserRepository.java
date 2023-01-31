package ch.tbz.entity.user;

import ch.tbz.generic.AbstractEntityRepository;
import ch.tbz.util.API;

public class UserRepository extends AbstractEntityRepository<User> {
    public UserRepository(API api) {
        super(api);
    }
}
