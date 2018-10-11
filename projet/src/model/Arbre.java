package model;

/**
 * Classe représentant l'arbre binaire contenant la traduction du morse
 * @author Mathieu
 *
 */
public class Arbre{
	private Object elem;
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
	 * @param elem : valeur contenue dans le Noeud
	 * @param gauche : Noeud de gauche (correspond à un ".")
	 * @param droite : Noeud de droite (correspond à un "-")
	 */
	public Arbre(Object elem, Arbre gauche, Arbre droite) {
		this.elem = elem;
		this.gauche = gauche;
		this.droite = droite;
	}
	
	/**
	 * retourne le noeud de gauche
	 * @return noeud gauche
	 */
	public Arbre getGauche() {
		return this.gauche;
	}
	
	/**
	 * retourne le noeud de droite
	 * @return noeud droite
	 */
	public Arbre getDroite() {
		return this.droite;
	}
	
	
}
