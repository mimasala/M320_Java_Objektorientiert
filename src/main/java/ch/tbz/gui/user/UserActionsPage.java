package ch.tbz.gui.user;
import ch.tbz.entity.user.User;
import ch.tbz.entity.user.UserController;
import ch.tbz.entity.user.UserRepository;
import ch.tbz.entity.user.UserService;
import ch.tbz.gui.ActionPage;
import ch.tbz.gui.GUIActions;
import ch.tbz.util.API;
import ch.tbz.util.JsonService;

import java.util.UUID;

import static ch.tbz.Main.getSystemProperties;
/**
 * User Actions Page
 * @author mytal
 * @version 1.0.0
 */
public class UserActionsPage extends ActionPage implements GUIActions {
    private final UserController userController;
    private final JsonService jsonService;
    public UserActionsPage() {
        super("User");
        UserRepository userRepository = new UserRepository(new API(getSystemProperties().getProperty("backend.url") + "user/"));
        UserService userService = new UserService(userRepository, User.class);
        this.userController = new UserController(userService);
        this.jsonService = new JsonService();
        addActionListeners();
    }

    @Override
    public void create() {
        userController.create(jsonService.fromJson(promptForInput("create"), User.class));
    }

    @Override
    public void update() {
        userController.update(jsonService.fromJson(promptForInput("update"), User.class));
    }

    @Override
    public void deleteById() {
        userController.deleteById(UUID.fromString(promptForInput("deleteById")));
    }

    @Override
    public void findById() {
        customizeOutputLabel(userController.findById(UUID.fromString(promptForInput("findById"))));
    }

    @Override
    public void findAll() {
        customizeOutputLabel(jsonService.listToPrettyJson(userController.findAll()));
    }
    private void addActionListeners(){
        getButtons().forEach(button -> button.addActionListener(e -> {
            String action = button.getText();
            switch (action) {
                case "find all" -> findAll();
                case "create" -> create();
                case "update" -> update();
                case "delete by id" -> deleteById();
                case "find by id" -> findById();
            }
        }));
    }
}