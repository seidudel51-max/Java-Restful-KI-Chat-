package RESTFULKICHAT;

import javax.swing.*;
import java.awt.*;

public class SaveChatDialog extends JDialog 
{

    private boolean saved = false;
    private boolean lokal = true;
    private JTextField txtName;

    // Konstruktor Dialog
    public SaveChatDialog(JFrame parent) 
    {
        super(parent, "Chat speichern", true);
        setSize(360, 160);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        txtName = new JTextField();
        add(new JLabel("Chatname:"), BorderLayout.NORTH);
        add(txtName, BorderLayout.CENTER);

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnLokal = new JButton("Lokal speichern");
        JButton btnFrei = new JButton("Speicherort wählen");

        btnLokal.addActionListener(e -> speichern(true));
        btnFrei.addActionListener(e -> speichern(false));

        btns.add(btnFrei);
        btns.add(btnLokal);
        add(btns, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void speichern(boolean lokal) 
    {
        // setzt die Auswahl und schließt den Dialog
        if (!txtName.getText().trim().isEmpty()) 
        {
            this.lokal = lokal;
            saved = true;
            dispose();
        }
    }

    public boolean isSaved() 
    {
        // gibt zurück ob gespeichert wurde
        return saved;
    }

    public boolean istLokal() 
    {
        // gibt zurück ob lokal gespeichert werden soll
        return lokal;
    }

    public String getName() 
    {
        // gibt den eingegebenen Chatnamen zurück
        return txtName.getText().trim();
    }
}
