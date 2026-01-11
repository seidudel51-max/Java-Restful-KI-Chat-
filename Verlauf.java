package RESTFULKICHAT;

import java.time.LocalDate;
import java.util.ArrayList;

public class Verlauf
{
	private String name;
	private ArrayList<Textverlauf> textverlauliste;
	private LocalDate datum;
	public Verlauf(String name, ArrayList<Textverlauf> textverlauliste, LocalDate datum)
	{
		super();
		this.name = name;
		this.textverlauliste = textverlauliste;
		this.datum = datum;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public ArrayList<Textverlauf> getTextverlauliste()
	{
		return textverlauliste;
	}
	public void setTextverlauliste(ArrayList<Textverlauf> textverlauliste)
	{
		this.textverlauliste = textverlauliste;
	}
	public LocalDate getDatum()
	{
		return datum;
	}
	public void setDatum(LocalDate datum)
	{
		this.datum = datum;
	}

	@Override
	public String toString()
	{
		return   name +  datum;
	}

}
