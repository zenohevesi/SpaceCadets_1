import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.util.*;


public class Spacecadets1 {
	
	public static void main (String args[]) throws Exception {
		
		System.out.println("Enter the email ID you want to search for");
		Toolbox toolbox = new Toolbox();
		String ID = toolbox.readStringFromCmd();
		String stringURL = urlConcat(ID);
		List<String> HTMLstring = URLtoHTML(stringURL);
		String LineContTitle = HTMLstring.get(8);
		if (LineContTitle.contains("|")){
			String[] splitLine = LineContTitle.split(">");
			String[] Title = splitLine[1].split("\\|");
			System.out.println("=================================");
			System.out.println(Title[0]);
			System.out.println("=================================");
		}
		else {System.out.println("Invalid ID");}
	}
	public static String urlConcat(String ID) {
		
		String URLBase = "http://ecs.soton.ac.uk/people/";
		String URL = URLBase.concat(ID);
		return URL;
	}
	public static List<String> URLtoHTML(String stringURL) {
		
		List<String> lines = new ArrayList<String>();
		try {
			URL readyURL = new URL(stringURL);
			BufferedReader in = new BufferedReader(new InputStreamReader(readyURL.openStream()));
		
			String line;
			while ((line = in.readLine()) != null){
				lines.add(line);
				//System.out.println(line);
			}
			in.close();	
			return lines;
		} catch(IOException e1) {e1.printStackTrace();}
		return lines;
	}
}


