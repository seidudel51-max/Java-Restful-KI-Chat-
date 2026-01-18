package RESTFULKICHAT;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class DHLIO extends DateiHandler 
{

    @Override
    public void schreiben(Verlauf verlauf, String dateiname) throws Exception 
    {

        try (BufferedWriter out = new BufferedWriter(new FileWriter(dateiname))) 
        {

            out.write("Chat: " + verlauf.getName());
            out.newLine();

            for (Textverlauf t : verlauf.getNachrichten()) 
            {
                out.write("Du: " + t.getFrage());
                out.newLine();
                out.write("KI: " + t.getAntwort());
                out.newLine();
                out.newLine();
            }
        }
    }
}
