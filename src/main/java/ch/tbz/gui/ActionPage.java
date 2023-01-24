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

    private final String[] actions = new String[] {
            "find all",
            "create",
            "update",
            "delete",
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
