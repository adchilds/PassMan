package com.github.adchilds.passman.ui.panel;

import com.github.adchilds.passman.ui.MainFrame;
import com.github.adchilds.passman.ui.panel.PassManPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 */
public class DashboardPanel extends PassManPanel implements ActionListener, KeyListener {

    /**
     *
     * @param mainFrame
     */
    public DashboardPanel(MainFrame mainFrame, int borderTop, int borderLeft, int panelHeight, int panelWidth) {
        super(mainFrame, borderTop, borderLeft, panelHeight, panelWidth);

        createPanel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createPanel() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

}