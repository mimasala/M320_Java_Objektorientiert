package ch.tbz.entity.user;

import ch.tbz.generic.AbstractEntityController;
import ch.tbz.generic.AbstractEntityService;

/**
 * User Controller
 * @author mytal
 * @version 1.0.0
 */
public class UserController extends AbstractEntityController<User> {
    public UserController(AbstractEntityService<User> service) {
        super(service);
    }
}
