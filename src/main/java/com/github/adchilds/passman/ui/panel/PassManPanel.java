package com.github.adchilds.passman.ui.panel;

import com.github.adchilds.passman.ui.MainFrame;

import javax.swing.*;

/**
 *
 */
public abstract class PassManPanel extends JPanel {

    protected int borderTop;
    protected int borderLeft;
    protected MainFrame mainFrame;
    protected int panelHeight;
    protected int panelWidth;

    public PassManPanel(MainFrame mainFrame, int borderTop, int borderLeft, int panelHeight, int panelWidth) {
        this.borderTop = borderTop;
        this.borderLeft = borderLeft;
        this.mainFrame = mainFrame;
        this.panelHeight = panelHeight;
        this.panelWidth = panelWidth;
    }

    public abstract void createPanel();

    public int getBorderTop() {
        return borderTop;
    }

    public void setBorderTop(int borderTop) {
        this.borderTop = borderTop;
    }

    public int getBorderLeft() {
        return borderLeft;
    }

    public void setBorderLeft(int borderLeft) {
        this.borderLeft = borderLeft;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public int getPanelHeight() {
        return panelHeight;
    }

    public void setPanelHeight(int panelHeight) {
        this.panelHeight = panelHeight;
    }

    public int getPanelWidth() {
        return panelWidth;
    }

    public void setPanelWidth(int panelWidth) {
        this.panelWidth = panelWidth;
    }

}