package ch.tbz.gui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

@Getter@Setter
public abstract class ActionPage extends JFrame {
    private boolean isWindowCreated;

    private final String[] actions = new String[] {
            "create",
            "update",
            "delete",
            "delete by id",
            "find by id",
            "upload .json"
    };
    public ActionPage(String title) {
        setTitle(title);
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        createActionButtons();

        setVisible(true);
        isWindowCreated = true;
    }

    public void createActionButtons() {
        Arrays.stream(actions).forEach(action -> {
            JButton button = new JButton(action);
            add(button);
        });
    }
}
