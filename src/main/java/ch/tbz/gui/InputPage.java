package ch.tbz.gui;

import lombok.Getter;

import javax.swing.*;

@Getter
public class InputPage extends JFrame {
    private final JTextField textField;
    public InputPage(String title) {
        this.textField = new JTextField();
        setTitle(title);
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        add(textField);
        pack();
        setVisible(true);
    }
}
