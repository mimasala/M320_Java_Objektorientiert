package ch.tbz.gui.osu;

import ch.tbz.entity.osu.Osu;
import ch.tbz.entity.osu.OsuController;
import ch.tbz.entity.osu.OsuRepository;
import ch.tbz.entity.osu.OsuService;
import ch.tbz.gui.ActionPage;
import ch.tbz.gui.GUIActions;
import ch.tbz.gui.InputPage;
import ch.tbz.util.API;
import ch.tbz.util.JsonService;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.UUID;

import static ch.tbz.Main.getSystemProperties;

public class OsuActionsPage extends ActionPage implements GUIActions {
    private final OsuController osuController;
    private final JLabel outputLabel = new JLabel();
    private InputPage inputPage;

    public OsuActionsPage() {
        super("OSU");
        OsuRepository osuRepository = new OsuRepository(new API(getSystemProperties().getProperty("backend.url") + "osu/"));
        OsuService osuService = new OsuService(osuRepository, Osu.class);
        this.osuController = new OsuController(osuService);

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
            osuController.create(inputPage.getTextField().getText());
            inputPage.dispose();
        });
    }

    @Override
    public void update() {
        inputPage = new InputPage("update");
        inputPage.getTextField().addActionListener(e -> {
            osuController.update(inputPage.getTextField().getText());
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
        inputPage.getTextField().addActionListener(e ->
                osuController.update(inputPage.getTextField().getText()));
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
                case "upload .json" -> uploadJson();
            }
        }));
    }
}