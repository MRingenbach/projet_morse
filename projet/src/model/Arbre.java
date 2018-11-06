package model;

/**
 * Classe représentant l'arbre binaire contenant la traduction du morse
 * @author Mathieu
 *
 */
public class Arbre {
	private String elem;
	private Arbre gauche;
	private Arbre droite;
	
	/**
	 * Constructeur par défaut, créé un Noeud vide
	 */
	public Arbre() {
		this.elem = null;
		this.gauche = null;
		this.droite = null;
	}
	
	/**
	 * Constructeur de la classe Arbre
	 * @param elem valeur contenue dans le Noeud
	 * @param gauche Noeud de gauche (correspond à un ".")
	 * @param droite Noeud de droite (correspond à un "-")
	 */
	public Arbre(String elem, Arbre gauche, Arbre droite) {
		this.elem = elem;
		this.gauche = gauche;
		this.droite = droite;
	}
	
	/**
	 * Constructeur du noeud racine
	 * @param gauche Noeud de gauche (correspond à un ".")
	 * @param droite Noeud de droite (correspond à un "-")
	 */
	public Arbre(Arbre gauche, Arbre droite) {
		this.elem = "";
		this.gauche = gauche;
		this.droite = droite;
	}
	
	public Arbre(int prof) {
		this.elem = null;
		this.gauche = null;
		this.droite = null;
		this.construct(prof-1);
	}
	
	public void construct(int prof) {
		if (prof > 0) {
			this.gauche = new Arbre();
			this.droite = new Arbre();
			this.gauche.construct(prof-1);
			this.droite.construct(prof-1);
		}
	}
	
	/**
	 * retourne le noeud de gauche
	 * @return noeud gauche
	 */
	public Arbre getGauche() {
		return this.gauche;
	}
	
	public void setElem(String value) {
		this.elem = value;
	}
	
	/**
	 * retourne le noeud de droite
	 * @return noeud droite
	 */
	public Arbre getDroite() {
		return this.droite;
	}
	
	/**
	 * attribue a la variable gauche le noeud passé en paramètre
	 * @param g
	 */
	public void setGauche(Arbre g) {
		this.gauche = g;
	}
	
	/**
	 * attribue a la variable droite le noeud passé en paramètre
	 * @param d
	 */
	public void setDroite(Arbre d) {
		this.droite = d;
	}
	
	/**
	 * retourne le contenu du noeud
	 * @return elem
	 */
	public String getElem() {
		return this.elem;
	}
	
	/**
	 * affiche le contenu de l'arbre a partir du noeud courrant
	 */
	public void display() {
		if (this != null) {
			System.out.println(this.getElem());
			if (this.gauche != null)
				this.gauche.display();
			if (this.droite != null)
				this.droite.display();
		}
	}
	
	/**
	 * traduit le morse en lettres
	 * @param morse chaine de code morse
	 * @return la chaine de caractères correspondante au code en morse
	 */
	public String getLetter(String morse) {
		Arbre current = this;
		for (int i = 0; i < morse.length(); i++) {
			System.out.println(morse.substring(i, i+1));
			current = current.getNext(morse.charAt(i));
		}
		return current.getElem().toString();
	}
	
	
	public Arbre getNext(char morseChar) {
		Arbre res = null;
		switch (morseChar) {
			case '.' : 
				res = this.getGauche();
				break;
			case '-':
				res = this.getDroite();
				break;
		}
		return res;
	}
	
	public boolean add(String value, String path, char g, char d) {
		if (value != null && path != null) {
			if (value == "") {
				System.out.println("ah ?");
				this.setElem(value);
				return true;
			}
			else {
				char c = path.charAt(0);
				if (path.length() == 1) {
					if (c == g) {
						this.getGauche().setElem(value);
					}
					else if (c == d) {
						this.getDroite().setElem(value);
					}
					return true;
				}
				else if (path.length() > 1) {
					if (c == g) {
						if (this.getGauche() == null)
							return false;
						return this.getGauche().add(value, path.substring(1), g, d);
					}
					else if (c == d) {
						if (this.getDroite() == null)
							return false;
						return this.getDroite().add(value, path.substring(1), g, d);
					}
					return false;
				}
				else
					return false;
			}
		}
		else {
			return false;
		}
	}
}
