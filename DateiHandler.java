package RESTFULKICHAT;

import java.util.List;

public abstract class DateiHandler 
{

    // Schreiben (IO oder NIO – je nach Implementierung)
    public abstract void schreiben(Verlauf verlauf, String dateiname) throws Exception;

    // 👉 Lesen IMMER mit NIO
    public List<String> lesen(String dateiname) throws Exception 
    {
        return java.nio.file.Files.readAllLines(java.nio.file.Path.of(dateiname));
    }
}
