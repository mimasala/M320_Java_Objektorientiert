package ch.tbz.gui.osu;

import ch.tbz.entity.osu.Osu;
import ch.tbz.entity.osu.OsuController;
import ch.tbz.entity.osu.OsuRepository;
import ch.tbz.entity.osu.OsuService;
import ch.tbz.gui.ActionPage;
import ch.tbz.gui.GUIActions;
import ch.tbz.gui.InputPage;
import ch.tbz.util.JsonService;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.UUID;

public class OsuActionsPage extends ActionPage implements GUIActions {
    private final JsonService<Osu> jsonService;
    private final OsuController osuController;
    private final JLabel outputLabel = new JLabel();
    private InputPage inputPage;
    public OsuActionsPage() {
        super("OSU");
        OsuRepository osuRepository = new OsuRepository();
        OsuService osuService = new OsuService(osuRepository);
        this.osuController = new OsuController(osuService);
        this.jsonService = new JsonService<>();

        outputLabel.setPreferredSize(new Dimension(getWidth(), 600));
        outputLabel.setHorizontalAlignment(SwingConstants.CENTER);

        addActionListeners();

    }

    private void customizeOutputLabel(String text) {
        outputLabel.setText(text);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        outputLabel.setForeground(Color.RED);
        add(outputLabel);
    }



    @Override
    public void create() {
        System.out.println("hello create");
        inputPage = new InputPage("create");
        inputPage.getTextField().addActionListener(e -> {
            osuController.create(
                    jsonService.read(
                            inputPage.getTextField().getText(), Osu.class));
            inputPage.dispose();
        });
    }

    @Override
    public void update() {
        inputPage = new InputPage("update");
        inputPage.getTextField().addActionListener(e -> {
            osuController.update(
                    jsonService.read(
                            inputPage.getTextField().getText(), Osu.class));
            inputPage.dispose();
        });
    }

    @Override
    public void delete() {
        inputPage = new InputPage("delete");
        inputPage.getTextField().addActionListener(e -> {
            osuController.delete(
                    jsonService.read(
                            inputPage.getTextField().getText(), Osu.class));
            inputPage.dispose();
        });
    }

    @Override
    public void deleteById() {
        inputPage = new InputPage("deleteById");
        inputPage.getTextField().addActionListener(e -> {
            osuController.deleteById(UUID.fromString(
                    inputPage.getTextField().getText()));
            inputPage.dispose();
        });
    }

    @Override
    public void findById() {
        inputPage = new InputPage("findById");
        inputPage.getTextField().addActionListener(e -> {
            customizeOutputLabel(osuController.findById(
                    UUID.fromString(
                            inputPage.getTextField().getText())));
            inputPage.dispose();
        });
    }

    @Override
    public void findAll() {
        System.out.println("hello findAll");
        customizeOutputLabel(Arrays.toString(osuController.findAll().toArray()));
    }

    @Override
    public void uploadJson() {
        inputPage = new InputPage("uploadJson");
        inputPage.getTextField().addActionListener(e -> osuController.update(
                jsonService.read(
                        inputPage.getTextField().getText(), Osu.class)));
    }
    private void addActionListeners(){
        getButtons().forEach(button -> button.addActionListener(e -> {
            String action = button.getText();
            switch (action) {
                case "find all" -> findAll();
                case "create" -> create();
                case "update" -> update();
                case "delete" -> delete();
                case "delete by id" -> deleteById();
                case "find by id" -> findById();
                case "upload .json" -> uploadJson();
            }
        }));
    }
}