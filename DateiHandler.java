package RESTFULKICHAT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
	 
public abstract class DateiHandler
{
	protected ArrayList<Textverlauf> testliste = new ArrayList<>();
	protected BufferedWriter out;
	protected BufferedReader in;
 
	public abstract BufferedWriter schreiben(String speicherort, String dateiname);
	 
	public ArrayList<Textverlauf> auslesen (BufferedReader in)
	{
		String zeile = null;
	 
	 
		try
		{
			zeile = in.readLine();
		} catch (IOException e)
		{
	 				e.printStackTrace();
		}
		try
		{
			while((zeile = in.readLine())!= null)
			{
//					double dummy;
//					String[] split = zeile.split(";");
//					split[2] = split[2].replaceAll(",",".");
//					split[2] = split[2].replaceAll("€", "");
//					dummy = Double.parseDouble(split[2]);
//					testliste.add(new Artikel(split[0], split[1], dummy));
	 
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				in.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return testliste;
	 
	}
	 
	 
	public void schreibenDatei(DefaultListModel<Artikel> abc, BufferedWriter out)
	{
		try
		{
		out.write(abc.toString());
		out.newLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				out.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	 
	public BufferedWriter getOut()
	{
		return out;
	}
	 
	public void setOut(BufferedWriter out)
	{
		this.out = out;
	}
	 
	public BufferedReader getIn()
	{
		return in;
	}
	 
	public void setIn(BufferedReader in)
	{
		this.in = in;
	}
	 
}
