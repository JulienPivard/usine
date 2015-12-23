package usine.modele.difficulte;

/**
 * Fabrique abstraite de difficultés.
 * @author PIVARD Julien, CLECH Sandy
 */
public interface FabriqueDifficultesAbstraite
{

    /**
     * @return La difficulté Facile
     */
    public DifficulteAbstraite faireFacile();

    /**
     * @return La difficulté Moyenne
     */
    public DifficulteAbstraite faireMoyen();

    /**
     * @return La difficulté Difficile
     */
    public DifficulteAbstraite faireDifficile();

}
