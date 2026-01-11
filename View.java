package RESTFULKICHAT;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JList listThemenVerlauf; 
    private JButton btnSenden;
    private JTextPane textPaneEingabe;  
    private JTextPane textPaneTextverlauf; 
    private JScrollPane scrollVerlauf;
    private JScrollPane scrollEingabe;   
    private JButton btnspeichen;
    public View() {
        initialize();
    }

    private void initialize() {
        setTitle("RESTful KI Chat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 480);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null); // falls du absolute Positionen behalten willst
        setContentPane(contentPane);

        contentPane.add(getListThemenVerlauf());

        scrollVerlauf = new JScrollPane(getTextPaneTextverlauf());
        scrollVerlauf.setBounds(256, 10, 400, 330);
        scrollVerlauf.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contentPane.add(scrollVerlauf);

        scrollEingabe = new JScrollPane(getTextPaneEingabe());
        scrollEingabe.setBounds(256, 351, 341, 78);
        scrollEingabe.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contentPane.add(scrollEingabe);

        contentPane.add(getBtnSenden());

        setVisible(true);
    	contentPane.add(getBtnspeichen());
    }

    protected JList getListThemenVerlauf() {
        if (listThemenVerlauf == null) {
            listThemenVerlauf = new JList();
            listThemenVerlauf.setBounds(23, 10, 207, 419);
        }
        return listThemenVerlauf;
    }

    protected JButton getBtnSenden() {
        if (btnSenden == null) {
            btnSenden = new JButton("");
            btnSenden.setBounds(607, 351, 49, 38);

            // Original Icon laden
            ImageIcon icon = new ImageIcon("C:\\Users\\jamal\\OneDrive\\Desktop\\1111.jpg");

            // Bild skalieren
            Image img = icon.getImage().getScaledInstance(
                    59, 53, Image.SCALE_SMOOTH
            );

            // Skaliertes Bild wieder als Icon setzen
            ImageIcon scaledIcon = new ImageIcon(img);
            btnSenden.setIcon(scaledIcon);
        }
        return btnSenden;
    }

    protected JTextPane getTextPaneEingabe() {
        if (textPaneEingabe == null) {
            textPaneEingabe = new JTextPane();
            // Zeilenumbruch im JTextPane standardmäßig aktiv
        }
        return textPaneEingabe;
    }

    protected JTextPane getTextPaneTextverlauf() {
        if (textPaneTextverlauf == null) {
            textPaneTextverlauf = new JTextPane();
            textPaneTextverlauf.setEditable(false); // Verlauf nur lesen
            // Optional: Style für bessere Lesbarkeit
        }
        return textPaneTextverlauf;
    }
    private JButton getBtnspeichen() {
        if (btnspeichen == null) {
            btnspeichen = new JButton("");

            btnspeichen.setBounds(607, 391, 49, 38);

            // Bild laden
            ImageIcon icon = new ImageIcon(
                "C:\\Users\\jamal\\OneDrive\\Desktop\\Image(9).jpg"
            );

            // Bild auf Button-Größe skalieren
            Image img = icon.getImage().getScaledInstance(
                    44, 38, Image.SCALE_SMOOTH
            );

            btnspeichen.setIcon(new ImageIcon(img));

            btnspeichen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
        }
        return btnspeichen;
    }
	
}
