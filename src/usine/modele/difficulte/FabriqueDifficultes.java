package usine.modele.difficulte;


/**
 * Fabrique concrète de difficultés.
 * @author PIVARD Julien, CLECH Sandy
 */
public class FabriqueDifficultes implements FabriqueDifficultesAbstraite
{

    /**
     * @return La difficulté Facile
     * */
    @Override
    public DifficulteAbstraite faireFacile()
    {
        return Facile.instance;
    }

    /**
     * @return La difficulté Moyen
     * */
    @Override
    public DifficulteAbstraite faireMoyen()
    {
        return Moyen.instance;
    }

    /**
     * @return La difficulté Difficile
     * */
    @Override
    public DifficulteAbstraite faireDifficile()
    {
        return Difficile.instance;
    }

}
