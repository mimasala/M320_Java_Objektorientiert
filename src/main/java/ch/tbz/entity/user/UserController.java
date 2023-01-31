package ch.tbz.entity.user;

import ch.tbz.generic.AbstractEntityController;
import ch.tbz.generic.AbstractEntityService;

public class UserController extends AbstractEntityController<User> {
    public UserController(AbstractEntityService<User> service) {
        super(service);
    }
}
