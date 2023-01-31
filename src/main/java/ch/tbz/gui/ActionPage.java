package ch.tbz.gui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter@Setter
public abstract class ActionPage extends JFrame {
    private boolean isWindowCreated;
    private List<JButton> buttons;
    private Console outputConsole = new Console();

    private final String[] actions = new String[] {
            "find all",
            "create",
            "update",
            "delete by id",
            "find by id",
            "upload .json"
    };
    public ActionPage(String title) {
        this.buttons = new ArrayList<>();
        setTitle(title);
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        outputConsole.textPane.append(new Color(244, 244, 244), "Welcome to the " + title + " Actions Page");

        createActionButtons();

        setVisible(true);
        isWindowCreated = true;
    }

    public void createActionButtons() {
        Arrays.stream(actions).forEach(action -> {
            JButton button = new JButton(action);
            buttons.add(button);
            add(button);
        });
    }
}
