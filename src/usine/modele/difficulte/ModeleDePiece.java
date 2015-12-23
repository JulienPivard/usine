package usine.modele.difficulte;

import usine.modele.piece.Piece;
import usine.modele.piece.Trou;

/**
 * Pièce que l'ont vas devoir reproduire.
 * @author PIVARD Julien
 */
public class ModeleDePiece extends Piece
{

    /**
     * La difficultés choisie pour créer une pièce.
     * */
    protected DifficulteAbstraite difficultee;

    /**
     * Pièce que l'ont vas devoir reproduire.
     * */
    public ModeleDePiece(DifficulteAbstraite difficultee)
    {
        super();
        this.difficultee = difficultee;
    }

    /**
     * @return La difficulté choisie.
     * */
    public DifficulteAbstraite getDifficulte()
    {
        return difficultee;
    }

    /**
     * @param difficultee
     * La difficulté du modelé de la pièce.
     * */
    public void setDifficulte(DifficulteAbstraite difficultee)
    {
        this.difficultee = difficultee;
    }

    /**
     * @return La pièce à une diagonal usinée et ou gravée.
     * */
    public boolean diagonalCouranteUsine()
    {
        return getDiagonalCourante().estUsine();
    }

    /**
     * Perce et/ou grave la diagonal courante.
     * @return La diagonal a été modifiée.
     * */
    public boolean usinerDiagonalCouranteAleatoirement()
    {
        boolean reussite = getDiagonalCourante().graverOuPercerAleatoirement();
        if(!(diagonales[diagonalCourante].getPercage() == Trou.Deux))
        {
            percerUn();
        }
        return reussite;
    }

    /**
     * Lance la production de la pièce par la difficultés.
     * */
    public void produire()
    {
        this.reinitialiserDiagonales();
        difficultee.produirePiece(this);
    }

    /**
     * Fait pivoter la pièce d'un certain nombre de diagonales.
     * @param nombreDeDiagonal
     * Le nombre de diagonal dont on veut faire pivoter la pièce.
     * */
    public void changerDiagonale(int nombreDeDiagonal)
    {
    	super.pivoter(nombreDeDiagonal);
    }

}
