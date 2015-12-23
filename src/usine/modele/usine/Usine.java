package usine.modele.usine;

import usine.modele.difficulte.DifficulteAbstraite;
import usine.modele.difficulte.ModeleDePiece;
import usine.modele.machines.Machine;
import usine.modele.piece.Piece;

/**
 * Modèle de l'application.
 * @author PIVARD Julien, CLECH Sandy
 */
public class Usine
{
	/**
	 * La pièce que l'on va usiner.
	 */
	protected Piece piece;

    /**
     * La pièce à reproduire.
     */
    protected ModeleDePiece modele ;

    /**
     * Chaîne de production.
     */
    protected PlaceMachine machines[] = new PlaceMachine[8];

    /**
     * Une usine de 8 machines avec un modelé de pièce.
     * @param machine
     * Le modèle de la pièce à reproduire.
     * @param difficulte
     * La fabrique qui vas servir à faire les machines.
     * */
    public Usine(Machine machine, DifficulteAbstraite difficulte)
    {
        for(int i = 0; i < machines.length; i++)
        {
            machines[i] = new PlaceMachine(machine);
        }
        this.modele = new ModeleDePiece(difficulte);
        fairePieceModele();
        this.piece = new Piece();
    }

    /**
     * @param difficulte
     * La nouvelle difficulté.
     * */
    public void setDifficulte(DifficulteAbstraite difficulte)
    {
        modele.setDifficulte(difficulte);
    }

    /**
     * Lance l'usinage de la pièce par les machines.
     * */
    public void usiner()
    {
        piece.reinitialiserDiagonales();
        for(PlaceMachine m : machines)
        {
            m.usiner(piece);
        }
    }

    /**
     * @param numPlace
     * Le numéro de la machine à modifier.
     * @param machine
     * La machine à mettre.
     * */
    public void setMachine(int numPlace, Machine machine)
    {
        // On vérifie la plage de valeurs
        if(numPlace<0 || numPlace>machines.length)
        {
            System.err.println("La valeur : " + numPlace + " n'est pas comprise entre 0 et " + machines.length);
            return;
        }
        machines[numPlace].setMachine(machine);
    }

    /**
     * Crée le modèle de la pièce selon la difficulté choisie.
     * */
    public void fairePieceModele()
    {
        modele.produire();
    }

    /**
     * retourne la machine qui est a la place donnée
     * @param place
     * le slot qu'on veut regarder.
     * @return la machine contenue dans le slot demandé.
     */
    public PlaceMachine getSlot(int place){
    	if(place<0 || place>machines.length)
        {
            System.err.println("La valeur : " + place + " n'est pas comprise entre 0 et " + machines.length);
            return null;
        }
    	return machines[place];
    }
    
    
    /**
     * remettre la même machine dans tous les slots.
     * @param machine
     * machine a mettre dans les slots
     */
    public void reinitialiserMachines(Machine machine){
    	for(int i = 0; i < machines.length; i++)
        {
            machines[i] = new PlaceMachine(machine);
        }
    	
    }
    
    /**
     * Change la machine à la place donnée.
     * @param place
     */
    public void machineSuivante(int place){
    	machines[place].machineSuivante();
    }
    
	/**
	 * Récupére la pièce usinée dans l'usine.
	 * @return la pièce usinée.
	 */
    public Piece getPiece(){
    	return this.piece;
    }
    
	/**
	 * Récupère la pièce modèle.
	 * @return la pièce modèle.
	 */
    public ModeleDePiece getModeleDePiece(){
    	return this.modele;
    }

	/**
	 * Décide si la pièce usinée correspond au modèle.
	 * @return true si les pièces sont identiques, false sinon.
	 */
	public boolean getVerdict() {
		return piece.comparer(modele);
	}
	
	/**
	 * Créer une nouvelle partie
	 */
	public void reinitialiser() {
		reinitialiserMachines(Machine.PosteVide);
		fairePieceModele();
		usiner();
	}
}
