package RESTFULKICHAT;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
 
public class DHLNIO extends DateiHandler
{
	public String path;
	
	public DHLNIO()
	{
		
	}
	
	public DHLNIO(String path)
	{
		this.path = path;
		try
		{
			in = Files.newBufferedReader(Paths.get(path));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public BufferedWriter schreiben(String speicherort, String dateiname)
	{
		try
		{
			out = Files.newBufferedWriter(Paths.get(speicherort + dateiname));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return out;
	}
}
