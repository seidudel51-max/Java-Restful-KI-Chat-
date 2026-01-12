package RESTFULKICHAT;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SaveChatDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JLabel labelChatName;
    private JTextField textFieldChatName;
    private JButton btnSave;

    private String chatName;
    private boolean saved = false;

    public SaveChatDialog(JFrame parent) {
        super(parent, "Chat speichern", true);
        initialize();
    }

    private void initialize() {
        setBounds(100, 100, 354, 137);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        contentPane.add(getLabelChatName());
        contentPane.add(getTextFieldChatName());
        contentPane.add(getBtnSave());

        setVisible(true);
    }

    private JLabel getLabelChatName() {
        if (labelChatName == null) {
            labelChatName = new JLabel("Chat Name:");
            labelChatName.setBounds(30, 12, 100, 25);
            labelChatName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }
        return labelChatName;
    }

    private JTextField getTextFieldChatName() {
        if (textFieldChatName == null) {
            textFieldChatName = new JTextField();
            textFieldChatName.setBounds(117, 11, 220, 25);
            textFieldChatName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }
        return textFieldChatName;
    }

    private JButton getBtnSave() {
        if (btnSave == null) {
            btnSave = new JButton("Save");
            btnSave.setBounds(238, 57, 84, 25);
            btnSave.setBackground(new Color(16, 185, 129));
            btnSave.setForeground(Color.WHITE);
            btnSave.setFont(new Font("Segoe UI", Font.BOLD, 14));
            btnSave.setFocusPainted(false);

            btnSave.addActionListener(e -> {
                chatName = textFieldChatName.getText().trim();
                if (!chatName.isEmpty()) {
                    saved = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Bitte geben Sie einen Chat-Namen ein!",
                            "Fehler",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });
        }
        return btnSave;
    }

    public String getChatName() {
        return chatName;
    }

    public boolean isSaved() {
        return saved;
    }
}
