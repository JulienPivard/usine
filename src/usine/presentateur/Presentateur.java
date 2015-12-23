package usine.presentateur;

import usine.modele.difficulte.FabriqueDifficultes;
import usine.modele.difficulte.FabriqueDifficultesAbstraite;
import usine.modele.difficulte.ModeleDePiece;
import usine.modele.machines.Machine;
import usine.modele.piece.Piece;
import usine.modele.usine.PlaceMachine;
import usine.modele.usine.Usine;
import usine.vue.Vue;


/**
 * Présentateur du MVP.
 * @author CLECH Sandy
 */
public class Presentateur
{
    protected Usine usine;
    protected final Vue vue;
    protected FabriqueDifficultesAbstraite difficulte = new FabriqueDifficultes();

    /**
     * Constructeur de la classe Presentateur
     */
    public Presentateur()
    {
        usine = new Usine(Machine.PosteVide, difficulte.faireFacile() );
        vue = new Vue(this);
    }

    /**
     * Afficher la fenêtre
     */
    public void demarrer()
    {
        // Calcul des dimensions de tous les composants de la vue.
        vue.pack();

        // Affichage : il existe maintenant deux threads.
        vue.setVisible(true);
    }

    /**
     * Donne la machine d'une place donnée
     * @param place
     * @return PlaceMachine
     */
    public PlaceMachine getSlot(int place)
    {
        return usine.getSlot(place);
    }

    /**
     * Change la machine à la place donnée et réusine la pièce.
     * @param place
     */
    public void machineSuivante(int place)
    {
        usine.machineSuivante(place);
        usine.usiner();
    }

    /**
     * Récupére la pièce usinée dans l'usine.
     * @return la pièce usinée.
     */
    public Piece getPiece()
    {
        return usine.getPiece();
    }

    /**
     * Récupère la pièce modèle.
     * @return la pièce modèle.
     */
    public ModeleDePiece getModeleDePiece()
    {
        return usine.getModeleDePiece();
    }

    /**
     * Décide si la pièce usinée correspond au modèle.
     * @return true si les pièces sont identiques, false sinon.
     */
    public boolean getVerdict()
    {
        return usine.getVerdict();
    }

    /**
     * Modifie la difficulté en Difficile.
     */
    public void setDifficulteDifficile()
    {
        usine.setDifficulte(difficulte.faireDifficile());
        usine.reinitialiser();
    }

    /**
     * Modifie la difficulté en Moyen.
     */
    public void setDifficulteMoyenne()
    {
        usine.setDifficulte(difficulte.faireMoyen());
        usine.reinitialiser();
    }

    /**
     * Modifie la difficulté en Facile.
     */
    public void setDifficulteFacile()
    {
        usine.setDifficulte(difficulte.faireFacile());
        usine.reinitialiser();
    }
}
