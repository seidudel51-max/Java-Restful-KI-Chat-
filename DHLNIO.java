package RESTFULKICHAT;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DHLNIO extends DateiHandler 
{

    @Override
    public void schreiben(Verlauf verlauf, String dateiname) throws Exception 
    {

        List<String> zeilen = new ArrayList<>();
        zeilen.add("Chat: " + verlauf.getName());
        zeilen.add("");

        for (Textverlauf t : verlauf.getNachrichten()) 
        {
            zeilen.add("Du: " + t.getFrage());
            zeilen.add("KI: " + t.getAntwort());
            zeilen.add("");
        }

        Files.write(Path.of(dateiname), zeilen);
    }
}
