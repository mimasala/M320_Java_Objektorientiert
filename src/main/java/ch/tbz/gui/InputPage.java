package ch.tbz.gui;

import lombok.Getter;

import javax.swing.*;
/**
 * Input Page
 * @author mytal
 * @version 1.0.0
 */
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
