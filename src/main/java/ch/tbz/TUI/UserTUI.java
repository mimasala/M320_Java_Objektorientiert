package ch.tbz.TUI;

import ch.tbz.entities.user.UserService;
import ch.tbz.helpers.InputService;
import ch.tbz.log.OsuLog;

public class UserTUI extends TUI {
    UserService service = new UserService();
    public UserTUI(String name) {
        super(name);
    }

    @Override
    public void startMenu() {
        System.out.println(mainScreen);
        String inp = InputService.getString();
        switch (inp) {
            case "1" -> OsuLog.info(service.getAll().toString());
            case "2" -> OsuLog.info(service.get(InputService.getNum("Enter id: ")).toString());
            case "3" -> {
                service.saveUserFromJsonString(InputService.getString("enter user json: "));
                OsuLog.info("User saved");
            }
            case "4" -> service.delete(InputService.getNum("Enter id: "));
            case "5" -> service.deleteUserByName(InputService.getString("Enter name: "));
            case "6" -> OsuLog.info(service.getByName(InputService.getString("Enter search term: ")));
            case "7" -> service.sortList();
            case "8" -> service.insertionSortByName();
            case "9" -> service.insertionSortByNameDesc();
        }
    }
}
