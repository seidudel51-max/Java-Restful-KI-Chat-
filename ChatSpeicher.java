package RESTFULKICHAT;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;

// speichert den Chatverlauf als XML und legt Versionen an, falls Datei existiert
public class ChatSpeicher 
{

    public static void speichernMitVersion(Verlauf v, File ziel) throws Exception 
    {
        // speichert den Chatverlauf als XML und legt Versionen an, falls Datei existiert
        if (ziel.exists()) 
        {
            int version = 1;
            File backup;
            do 
            {
                backup = new File(ziel.getParent(), ziel.getName().replace(".xml", "_v" + version + ".xml"));
                version++;
            } while (backup.exists());
            ziel.renameTo(backup);
        }

        XMLEncoder enc = null;
        try 
        {
            enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(ziel)));
            enc.writeObject(v);
        } 
        finally 
        {
            if (enc != null) 
            {
                enc.close();
            }
        }
    }
    
    // lädt den Chatverlauf aus einer XML-Datei
    public static Verlauf laden(File f) throws Exception 
    {
        XMLDecoder dec = null;
        Verlauf v = null;
        try 
        {
            dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(f)));
            v = (Verlauf) dec.readObject();
        } finally {
            if (dec != null) 
            {
                dec.close();
            }
        }
        return v;
    }
}
