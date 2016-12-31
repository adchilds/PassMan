package com.github.adchilds.passman.ui.panel;

import com.github.adchilds.passman.PassManConstants;
import com.github.adchilds.passman.authentication.service.PassManUserService;
import com.github.adchilds.passman.authentication.service.impl.PassManUserServiceImpl;
import com.github.adchilds.passman.ui.MainFrame;
import com.github.adchilds.passman.ui.SwingUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 */
public class LoginPanel extends PassManPanel implements ActionListener, KeyListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private PassManUserService userService;

    /**
     *
     * @param mainFrame
     */
    public LoginPanel(MainFrame mainFrame, int borderTop, int borderLeft, int panelHeight, int panelWidth) {
        super(mainFrame, borderTop, borderLeft, panelHeight, panelWidth);

        this.userService = new PassManUserServiceImpl();

        createPanel();
    }

    /**
     *
     */
    @Override
    public void createPanel(){
        setBorder(PassManConstants.PANEL_DEFAULT_BORDER);
        setBackground(PassManConstants.PANEL_DEFAULT_BACKGROUND_COLOR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(new Dimension(panelWidth, panelHeight));
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setBorder(SwingUtils.roundedBorder(5, false));
        addKeyListener(this);

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(PassManConstants.LOGIN_TEXTFIELD_WIDTH, PassManConstants.LOGIN_TEXTFIELD_HEIGHT));
        usernameField.addKeyListener(this);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(PassManConstants.LOGIN_TEXTFIELD_WIDTH, PassManConstants.LOGIN_TEXTFIELD_HEIGHT));
        passwordField.addKeyListener(this);

        JLabel usernameLabel = new JLabel(" Email address:");
        JPanel usernamePanel = SwingUtils.createTransparentJPanel(usernameLabel, usernameField);
        usernamePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        usernamePanel.addKeyListener(this);

        JLabel passwordLabel = new JLabel(" Password:");
        JPanel passwordPanel = SwingUtils.createTransparentJPanel(passwordLabel, passwordField);
        passwordPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        passwordPanel.addKeyListener(this);

        JButton loginButton = new JButton("Sign In");
        loginButton.setActionCommand(PassManConstants.COMMAND_SIGN_IN);
        loginButton.addActionListener(this);
        loginButton.addKeyListener(this);

        JButton registerButton = new JButton("Register");
        registerButton.setActionCommand(PassManConstants.COMMAND_REGISTER_SUBMIT);
        registerButton.addActionListener(this);
        registerButton.addKeyListener(this);

        JPanel buttonPanel = SwingUtils.createTransparentJPanel(loginButton, registerButton);
        buttonPanel.setBorder(new EmptyBorder(15, 0, 0, 0));

        add(usernamePanel);
        add(passwordPanel);
        add(buttonPanel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case PassManConstants.COMMAND_SIGN_IN:
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                boolean success = userService.authenticate(username, password);

                if (success) {

                } else {

                }

                break;

            case PassManConstants.COMMAND_REGISTER_SUBMIT:
                MainFrame.displayPanel(
                        new RegistrationPanel(
                                mainFrame,
                                PassManConstants.REG_BORDER_TOP,
                                PassManConstants.REG_BORDER_LEFT,
                                PassManConstants.REG_PANEL_HEIGHT,
                                PassManConstants.REG_PANEL_WIDTH
                        )
                );
                break;

            default:
                break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // Do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // Do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                break;

            default:
                break;
        }
    }

}