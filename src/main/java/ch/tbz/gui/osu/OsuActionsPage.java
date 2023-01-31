package ch.tbz.gui.osu;

import ch.tbz.entity.osu.Osu;
import ch.tbz.entity.osu.OsuController;
import ch.tbz.entity.osu.OsuRepository;
import ch.tbz.entity.osu.OsuService;
import ch.tbz.gui.ActionPage;
import ch.tbz.gui.GUIActions;
import ch.tbz.util.API;
import ch.tbz.util.JsonService;

import java.util.UUID;

import static ch.tbz.Main.getSystemProperties;

public class OsuActionsPage extends ActionPage implements GUIActions {
    private final OsuController osuController;
    private final JsonService jsonService;

    public OsuActionsPage() {
        super("Osu");
        OsuRepository osuRepository = new OsuRepository(new API(getSystemProperties().getProperty("backend.url") + "osu/"));
        OsuService osuService = new OsuService(osuRepository, Osu.class);
        this.osuController = new OsuController(osuService);
        this.jsonService = new JsonService();
        addActionListeners();
    }
    @Override
    public void create() {
        osuController.create(jsonService.fromJson(promptForInput("create"), Osu.class));
    }

    @Override
    public void update() {
        osuController.update(jsonService.fromJson(promptForInput("update"), Osu.class));
    }

    @Override
    public void deleteById() {
        osuController.deleteById(UUID.fromString(promptForInput("deleteById")));
    }

    @Override
    public void findById() {
        customizeOutputLabel(osuController.findById(UUID.fromString(promptForInput("findById"))));
    }

    @Override
    public void findAll() {
        customizeOutputLabel(jsonService.listToPrettyJson(osuController.findAll()));
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