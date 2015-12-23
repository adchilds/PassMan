package com.adamchilds.passman.ui;

import com.adamchilds.passman.PassManConstants;
import com.adamchilds.passman.ui.panel.PassManPanel;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class MainFrame extends JFrame {

    private JPanel container;

    /**
     *
     */
    public MainFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(PassManConstants.JFRAME_WIDTH, PassManConstants.JFRAME_HEIGHT));
        setResizable(false);
        setTitle(PassManConstants.JFRAME_TITLE);

        // Main application content pane
        container = new JPanel();
        container.setLayout(new BorderLayout());

        setContentPane(container);
        setLocationRelativeTo(null);
    }

    /**
     *
     * @param panel
     */
    public void displayPanel(PassManPanel panel) {
        // Remove whatever's currently displaying
        clear();

        // Setup the display
        container.add(SwingUtils.createBox(panel.getBorderLeft(), PassManConstants.JFRAME_HEIGHT), BorderLayout.WEST);
        container.add(SwingUtils.createBox(PassManConstants.JFRAME_WIDTH, panel.getBorderTop()), BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
        container.add(SwingUtils.createBox(PassManConstants.JFRAME_WIDTH, panel.getBorderTop()), BorderLayout.SOUTH);
        container.add(SwingUtils.createBox(panel.getBorderLeft(), PassManConstants.JFRAME_HEIGHT), BorderLayout.EAST);
        container.doLayout();

        container.repaint();
        container.revalidate();

        // Show the panel
        panel.setVisible(true);
    }

    /**
     * Clears all components from the current view.
     */
    public void clear() {
        container.removeAll();
        container.repaint();
    }

}