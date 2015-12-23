package usine.modele.difficulte;

/**
 * Difficulté concrète difficile.
 * @author PIVARD Julien, CLECH Sandy
 */
public class Difficile extends DifficulteAbstraite
{
    /**
     * Instance du Singleton
     */
    public final static DifficulteAbstraite instance = new Difficile();

    /**
     * Constructeur privé (Singleton)
     */
    private Difficile()
    {}

    /**
     * En facile va graver et/ou percer une diagonale au hasard sur la pièce.
     * En moyen va graver et/ou percer deux diagonales au hasard sur la pièce.
     * En difficile va graver et/ou percer trois diagonales au hasard sur la pièce.
     * */
    @Override
    public void produirePiece(ModeleDePiece piece)
    {
        usinerNDiagonales(piece, 3);
    }

}
