package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import model.Arbre;

/**
 * Classe gestionnaire d'arbre
 * @author Mathieu Ringenbach
 *
 */
public class GArbre
{
	private static Arbre racine;
	
	public static Arbre creerArbre() {
		racine = new Arbre(8);
		remplir();
		//racine.display();
		return racine;
	}
	
	public static void remplir() {
		try {
			InputStream is = GArbre.class.getResourceAsStream("/morse.txt");
			InputStreamReader lecture=new InputStreamReader(is);
			BufferedReader br = new BufferedReader(lecture);
			String line;
			
			while((line = br.readLine()) != null) {
				racine.add(line.substring(0, 1), line.substring(2), '.', '-');
			}
			
			br.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getLetter(String morse) {
		return racine.getLetter(morse).toString();
	}
	
	public static void add(String value, String path, char g, char d) {
		racine.add(value, path, g, d);
	}
}
