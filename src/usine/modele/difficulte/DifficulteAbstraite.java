package usine.modele.difficulte;



/**
 * Difficulté de la pièce.
 * @author PIVARD Julien, CLECH Sandy
 */
public abstract class DifficulteAbstraite
{

    /**
     * @param limiteSup
     * La valeur max que l'on veut + 1.
     * @return Une valeur aléatoire.
     * */
    protected int nbAleatoire(int limiteSup)
    {
        return (int)(Math.random() * limiteSup);
    }

    /**
     * Choisis de percer et/ou graver la diagonal courante.
     * Le nombre de trous et la taille des gravures sont choisis aléatoirement.
     * @param piece
     * La pièce à usiner
     * */
    protected void usinerAleatoirement(ModeleDePiece piece)
    {
        boolean aEteUsine = false;
        while(!aEteUsine)
        {
            aEteUsine = piece.usinerDiagonalCouranteAleatoirement();
        }
    }

    /**
     * Fait pivoter la pièce d'un nombre de diagonales aléatoirement jusqu'à trouver une diagonal vide.
     * @param piece
     * La pièce à usiner
     * */
    protected void choisirDiagonal(ModeleDePiece piece)
    {
        boolean diagonalPleine = true;
        while(diagonalPleine)
        {
            piece.changerDiagonale(nbAleatoire(4));
            // Détermine si la diagonal est pleine
            diagonalPleine = piece.diagonalCouranteUsine();
        }
    }

    /**
     * @param piece
     * La pièce à usiner.
     * @param nombreDeDiagonales
     * Le nombre de diagonales qui vont être usinées aléatoirement.
     * */
    protected void usinerNDiagonales(ModeleDePiece piece, int nombreDeDiagonales)
    {
        for(int i=0; i<nombreDeDiagonales; i++)
        {
            choisirDiagonal(piece);
            usinerAleatoirement(piece);
        }
    }

    /**
     * Produit la pièce selon la difficulté.
     * */
    public abstract void produirePiece(ModeleDePiece piece);

}
