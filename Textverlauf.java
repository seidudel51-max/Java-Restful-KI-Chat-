package RESTFULKICHAT;

public class Textverlauf
{
	private String frage;
	private String antwort;
	
	public Textverlauf(String frage, String antwort)
	{
		super();
		this.frage = frage;
		this.antwort = antwort;
	}
	
	public String getFrage()
	{
		return frage;
	}
	
	public void setFrage(String frage)
	{
		this.frage = frage;
	}
	
	public String getAntwort()
	{
		return antwort;
	}
	
	public void setAntwort(String antwort)
	{
		this.antwort = antwort;
	}
	
	@Override
	public String toString() {
	    return "Du: " + frage + "\nKI: " + antwort;
	}

}
