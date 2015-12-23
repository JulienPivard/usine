package usine.client;

import usine.presentateur.Presentateur;

/**
 * Point d'entrée de l'application.
 * @author PIVARD Julien, CLECH Sandy
 */
public class Client {
	
	/**
	 * Classe principale
	 * @param args les paramètres de la ligne de commande
	 */
	public static void main(String[] args){
		final Presentateur presentateur = new Presentateur();
		presentateur.demarrer();
	}
}
