package com.adamchilds.passman.ui;

import com.adamchilds.passman.PassManConstants;
import com.adamchilds.passman.authentication.model.PassManUser;
import com.adamchilds.passman.authentication.service.PassManUserService;
import com.adamchilds.passman.authentication.service.impl.PassManUserServiceImpl;

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
public class MainFrame extends JFrame implements ActionListener, KeyListener {

    private PassManUserService userService = new PassManUserServiceImpl();

    private JPanel container;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField passwordConfirmationField;

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
        container.addKeyListener(this);

        setContentPane(container);
        setLocationRelativeTo(null);
    }

    /**
     * Displays the login screen.
     */
    public void showLoginScreen() {
        clear();

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 0, 10));
        panel.setBackground(new Color(200, 200, 200));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setMaximumSize(new Dimension(PassManConstants.LOGIN_SCREEN_WIDTH, PassManConstants.LOGIN_SCREEN_HEIGHT));
        panel.setPreferredSize(new Dimension(PassManConstants.LOGIN_SCREEN_WIDTH, PassManConstants.LOGIN_SCREEN_HEIGHT));
        panel.setBorder(SwingUtils.roundedBorder(5, false));
        panel.addKeyListener(this);

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(PassManConstants.LOGIN_TEXTFIELD_WIDTH, PassManConstants.LOGIN_TEXTFIELD_HEIGHT));
        usernameField.addKeyListener(this);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(PassManConstants.LOGIN_TEXTFIELD_WIDTH, PassManConstants.LOGIN_TEXTFIELD_HEIGHT));
        passwordField.addKeyListener(this);

        JLabel usernameLabel = new JLabel(" Username:");
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
        registerButton.setActionCommand(PassManConstants.COMMAND_REGISTER);
        registerButton.addActionListener(this);
        registerButton.addKeyListener(this);

        JPanel buttonPanel = SwingUtils.createTransparentJPanel(loginButton, registerButton);
        buttonPanel.setBorder(new EmptyBorder(15, 0, 0, 0));

        panel.add(usernamePanel);
        panel.add(passwordPanel);
        panel.add(buttonPanel);

        container.add(Box.createRigidArea(new Dimension(PassManConstants.LOGIN_BORDER_WIDTH, PassManConstants.JFRAME_HEIGHT)), BorderLayout.WEST);
        container.add(Box.createRigidArea(new Dimension(PassManConstants.JFRAME_WIDTH, PassManConstants.LOGIN_BORDER_HEIGHT)), BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
        container.add(Box.createRigidArea(new Dimension(PassManConstants.JFRAME_WIDTH, PassManConstants.LOGIN_BORDER_HEIGHT)), BorderLayout.SOUTH);
        container.add(Box.createRigidArea(new Dimension(PassManConstants.LOGIN_BORDER_WIDTH, PassManConstants.JFRAME_HEIGHT)), BorderLayout.EAST);
    }

    /**
     *
     */
    public void showRegistrationScreen() {
        clear();

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 0, 10));
        panel.setBackground(new Color(200, 200, 200));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setMaximumSize(new Dimension(PassManConstants.LOGIN_SCREEN_WIDTH, PassManConstants.LOGIN_SCREEN_HEIGHT));
        panel.setPreferredSize(new Dimension(PassManConstants.LOGIN_SCREEN_WIDTH, PassManConstants.LOGIN_SCREEN_HEIGHT));
        panel.setBorder(SwingUtils.roundedBorder(5, false));
        panel.addKeyListener(this);

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(PassManConstants.LOGIN_TEXTFIELD_WIDTH, PassManConstants.LOGIN_TEXTFIELD_HEIGHT));
        usernameField.addKeyListener(this);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(PassManConstants.LOGIN_TEXTFIELD_WIDTH, PassManConstants.LOGIN_TEXTFIELD_HEIGHT));
        passwordField.addKeyListener(this);

        passwordConfirmationField = new JPasswordField();
        passwordConfirmationField.setPreferredSize(new Dimension(PassManConstants.LOGIN_TEXTFIELD_WIDTH, PassManConstants.LOGIN_TEXTFIELD_HEIGHT));
        passwordConfirmationField.addKeyListener(this);

        JLabel usernameLabel = new JLabel(" Username:");
        JPanel usernamePanel = SwingUtils.createTransparentJPanel(usernameLabel, usernameField);
        usernamePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        usernamePanel.addKeyListener(this);

        JLabel passwordLabel = new JLabel(" Password:");
        JPanel passwordPanel = SwingUtils.createTransparentJPanel(passwordLabel, passwordField);
        passwordPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        passwordPanel.addKeyListener(this);

        JLabel passwordConfirmationLabel = new JLabel(" Password Confirmation:");
        JPanel passwordConfirmationPanel = SwingUtils.createTransparentJPanel(passwordConfirmationLabel, passwordConfirmationField);
        passwordConfirmationPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        passwordConfirmationPanel.addKeyListener(this);

        JButton registerButton = new JButton("Register");
        registerButton.setActionCommand(PassManConstants.COMMAND_REGISTER);
        registerButton.addActionListener(this);
        registerButton.addKeyListener(this);

        JPanel buttonPanel = SwingUtils.createTransparentJPanel(registerButton);
        buttonPanel.setBorder(new EmptyBorder(15, 0, 0, 0));

        panel.add(usernamePanel);
        panel.add(passwordPanel);
        panel.add(passwordConfirmationPanel);
        panel.add(buttonPanel);

        container.add(Box.createRigidArea(new Dimension(PassManConstants.LOGIN_BORDER_WIDTH, PassManConstants.JFRAME_HEIGHT)), BorderLayout.WEST);
        container.add(Box.createRigidArea(new Dimension(PassManConstants.JFRAME_WIDTH, PassManConstants.LOGIN_BORDER_HEIGHT)), BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
        container.add(Box.createRigidArea(new Dimension(PassManConstants.JFRAME_WIDTH, PassManConstants.LOGIN_BORDER_HEIGHT)), BorderLayout.SOUTH);
        container.add(Box.createRigidArea(new Dimension(PassManConstants.LOGIN_BORDER_WIDTH, PassManConstants.JFRAME_HEIGHT)), BorderLayout.EAST);

        container.doLayout();
    }

    /**
     *
     */
    public void showPasswordList() {
        clear();
    }

    /**
     * Clears all components from the current view.
     */
    public void clear() {
        getContentPane().removeAll();
        getContentPane().repaint();
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

            case PassManConstants.COMMAND_REGISTER:
                showRegistrationScreen();
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