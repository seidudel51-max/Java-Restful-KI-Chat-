package RESTFULKICHAT;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class Controller 
{

    private View gui;
    
    private ArrayList<Textverlauf> textverlaufliste = new ArrayList<>();

    public Controller() 
    {
        this.gui = new View();
        registriereListener();
    }

    private void registriereListener() 
    {
        // Button senden
        gui.getBtnSenden().addActionListener(e -> eingabeSenden());

        // Enter-Taste im Eingabefeld
        gui.getTextPaneEingabe().addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
            	if (e.getKeyCode() == KeyEvent.VK_ENTER && !e.isShiftDown()) 
            	{
                    e.consume(); // verhindert Zeilenumbruch
                    eingabeSenden();
            	}
            }
        });
    }

    private void eingabeSenden() {
        String frage = gui.getTextPaneEingabe().getText().trim();
        if (frage.isBlank()) return;

        // API-Aufruf
        String antwort = API.frageKi(frage);

        // Textverlauf speichern
        Textverlauf tv = new Textverlauf(frage, antwort);
        textverlaufliste.add(tv);

        // Anzeige im TextPane **anhängen**
        Document doc = gui.getTextPaneTextverlauf().getDocument();
        try {
            doc.insertString(doc.getLength(), tv.toString() + "\n", null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Scroll automatisch nach unten
        gui.getTextPaneTextverlauf().setCaretPosition(doc.getLength());

        // Eingabefeld leeren
        gui.getTextPaneEingabe().setText("");
    }

}
