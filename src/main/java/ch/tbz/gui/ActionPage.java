package ch.tbz.gui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter@Setter
public abstract class ActionPage extends JFrame {
    private boolean isWindowCreated;
    public ActionPage(String title) {
        setTitle(title);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton getNameButton = new JButton("get" + title);
        add(getNameButton);

        JButton postNameButton = new JButton("post" + title);
        add(postNameButton);

        setVisible(true);
        isWindowCreated = true;
    }
}
