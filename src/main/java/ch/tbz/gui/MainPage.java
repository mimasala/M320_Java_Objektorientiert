package ch.tbz.gui;

import ch.tbz.gui.osu.OsuActionsPage;
import ch.tbz.gui.user.UserActionsPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 * Main Page
 * @author mytal
 * @version 1.0.0
 */
public class MainPage extends JFrame {
    private ActionPage actionPage;
    public MainPage() {
        setTitle("Main Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JLabel titleLabel = new JLabel("Welcome to the Main Page");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(this.getWidth(), 50));
        add(titleLabel);

        initButtons();

        JLabel titleImage = new JLabel(new ImageIcon("src/main/resources/images/title.png"));
        titleImage.setPreferredSize(new Dimension(this.getWidth(), 200));
        add(titleImage);

        setVisible(true);
    }
    private void initButtons() {
        JButton userActionsButton = new JButton("User Actions");
        add(userActionsButton);

        JButton osuActionsButton = new JButton("OSU Actions");
        add(osuActionsButton);

        userActionsButton.addActionListener(e -> {
            if (actionPage == null || !actionPage.isWindowCreated()) {
                actionPage = new UserActionsPage();
            } else {
                actionPage.setVisible(true);
            }
        });

        osuActionsButton.addActionListener(e -> {
            if (actionPage == null || !actionPage.isWindowCreated()) {
                actionPage = new OsuActionsPage();
            } else {
                actionPage.setVisible(true);
            }
        });
    }
}
