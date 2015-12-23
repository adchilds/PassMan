package com.adamchilds.passman.ui.panel;

import com.adamchilds.passman.PassManConstants;
import com.adamchilds.passman.ui.MainFrame;
import com.adamchilds.passman.ui.SwingUtils;
import com.adamchilds.passman.form.model.RegistrationForm;
import com.adamchilds.passman.form.validation.RegistrationFormValidator;

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
public class RegistrationPanel extends PassManPanel implements ActionListener, KeyListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField passwordConfirmationField;
    private JPasswordField secretPassphraseField;
    private RegistrationFormValidator validator;

    /**
     *
     */
    public RegistrationPanel(MainFrame mainFrame, int borderTop, int borderLeft, int panelHeight, int panelWidth) {
        super(mainFrame, borderTop, borderLeft, panelHeight, panelWidth);

        this.validator = new RegistrationFormValidator();

        createPanel();
    }

    /**
     *
     */
    @Override
    public void createPanel() {
        setBorder(new EmptyBorder(10, 10, 0, 10));
        setBackground(new Color(200, 200, 200));
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

        passwordConfirmationField = new JPasswordField();
        passwordConfirmationField.setPreferredSize(new Dimension(PassManConstants.LOGIN_TEXTFIELD_WIDTH, PassManConstants.LOGIN_TEXTFIELD_HEIGHT));
        passwordConfirmationField.addKeyListener(this);

        secretPassphraseField = new JPasswordField();
        secretPassphraseField.setPreferredSize(new Dimension(PassManConstants.LOGIN_TEXTFIELD_WIDTH, PassManConstants.LOGIN_TEXTFIELD_HEIGHT));
        secretPassphraseField.addKeyListener(this);

        JLabel usernameLabel = new JLabel(" Email address:");
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

        JLabel secretPassphraseLabel = new JLabel(" Secret Passphrase:");
        JPanel secretPassphrasePanel = SwingUtils.createTransparentJPanel(secretPassphraseLabel, secretPassphraseField);
        secretPassphrasePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        secretPassphrasePanel.addKeyListener(this);

        JButton registerButton = new JButton("Submit");
        registerButton.setActionCommand(PassManConstants.COMMAND_REGISTER);
        registerButton.addActionListener(this);
        registerButton.addKeyListener(this);

        JPanel buttonPanel = SwingUtils.createTransparentJPanel(registerButton);
        buttonPanel.setBorder(new EmptyBorder(15, 0, 0, 0));

        add(usernamePanel);
        add(passwordPanel);
        add(passwordConfirmationPanel);
        add(secretPassphrasePanel);
        add(buttonPanel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case PassManConstants.COMMAND_REGISTER:
                // Capture the entered information
                RegistrationForm form = new RegistrationForm(
                        usernameField.getText(),
                        passwordField.getPassword(),
                        passwordConfirmationField.getPassword(),
                        new String(secretPassphraseField.getPassword())
                );

                // Validate the entered information
                if (!validator.isValid(form)) {
                    // Show an appropriate error message
                    System.out.println("Invalid form fields.");
                } else {
                    // Create the new account
                    System.out.println("Valid form fields.");
                }

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