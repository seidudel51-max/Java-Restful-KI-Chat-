package RESTFULKICHAT;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public JList<String> liste = new JList<>();
    public JTextPane verlauf = new JTextPane();
    public JTextPane eingabe = new JTextPane();

    public JButton senden = new JButton("➤");
    public JButton speichern = new JButton("Speichern");
    public JButton loeschen = new JButton("Chat löschen");
    public JButton neuerChat = new JButton("Neuer Chat");

    public View() {
        setTitle("Restful KI Chat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);

        // ===== LINKS =====
        JPanel links = new JPanel(new BorderLayout(5,5));
        links.add(new JScrollPane(liste), BorderLayout.CENTER);

        JPanel linksButtons = new JPanel(new GridLayout(3,1,5,5));
        linksButtons.add(neuerChat);
        linksButtons.add(speichern);
        linksButtons.add(loeschen);

        links.add(linksButtons, BorderLayout.SOUTH);

        // ===== RECHTS =====
        JPanel rechts = new JPanel(new BorderLayout(5,5));
        verlauf.setEditable(false);
        rechts.add(new JScrollPane(verlauf), BorderLayout.CENTER);

        JPanel unten = new JPanel(new BorderLayout(5,5));
        unten.add(new JScrollPane(eingabe), BorderLayout.CENTER);
        unten.add(senden, BorderLayout.EAST);

        rechts.add(unten, BorderLayout.SOUTH);

        // ===== SPLIT =====
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, links, rechts);
        split.setDividerLocation(250);

        add(split);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
