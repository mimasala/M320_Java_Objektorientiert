package ch.tbz.gui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Action Page
 * @author mytal
 * @version 1.0.0
 */
@Getter@Setter
public abstract class ActionPage extends JFrame {
    private boolean isWindowCreated;
    private List<JButton> buttons;

    private final String[] actions = new String[] {
            "find all",
            "create",
            "update",
            "delete by id",
            "find by id"
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
    protected void customizeOutputLabel(String text, String title) {
        JTextArea textArea = new JTextArea(text);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
        JOptionPane.showMessageDialog(null, scrollPane, title,
                JOptionPane.INFORMATION_MESSAGE);
    }
    protected void customizeOutputLabel(String text) {
        customizeOutputLabel(text, "Osu Actions");
    }
    protected String promptForInput(String message) {
        return JOptionPane.showInputDialog(this, message);
    }
}
