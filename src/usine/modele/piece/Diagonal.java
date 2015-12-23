package usine.modele.piece;


/**
 * Représente la diagonal qui peut être percée ou gravée.
 * @author PIVARD Julien, CLECH Sandy
 */
public class Diagonal
{

    /**
     * Un trait d'épaisseur entre Fin et Epais.
     * */
    protected Trait trait;

    /**
     * Un nombre de trous entre 1 et 3.
     * */
    protected Trou trou;

    /**
     * Remet a Rien trou et trait.
     * */
    protected void reinitialiser()
    {
        trou = Trou.Rien;
        trait = Trait.Rien;
    }

    /**
     * Crée une diagonale vierge.
     * */
    public Diagonal()
    {
        trou = Trou.Rien;
        trait = Trait.Rien;
    }

    /**
     * @return Le perçage  de la diagonal
     * */
    public Trou getPercage()
    {
        return trou;
    }

    /**
     * @return La gravure actuel de la diagonal
     * */
    public Trait getGravure()
    {
        return trait;
    }

    /**
     * @return L'objet peut être gravé.
     * */
    public boolean peutGraver(Trait trait)
    {
        return this.trait.peutGraver(trait);
    }

    /**
     * @return L'objet n'est pas déjà percé.
     * */
    public boolean percageUtile(Trou trou)
    {
        return this.trou.percageUtile(trou);
    }

    /**
     * Grave et/ou perce un trou de manière aléatoire.
     * Doit au moins graver ou percer.
     * @return La diagonal à été modifiée.
     * */
    public boolean graverOuPercerAleatoirement()
    {
        Trou trouPrecedent = trou;
        Trait traitPrecedent = trait;
        trou = trou.nbTrouAleatoire();
        trait = trait.tailleGravureAleatoire();
        return trouPrecedent!=trou || traitPrecedent!=trait;
    }

    /**
     * Ajoute un trou dans la diagonal.
     * */
    public void percerUn()
    {
        trou = this.trou.percerUn();
    }

    /**
     * Ajoute deux trous dans la diagonal.
     * */
    public void percerDeux()
    {
        trou = this.trou.percerDeux();
    }

    /**
     * Perce trois trous dans la diagonal.
     * */
    public void percerTrois()
    {
        trou = this.trou.percerTrois();
    }

    /**
     * L'épaisseur du trait qui sera gravé.
     * */
    public void graverFin()
    {
        trait = this.trait.graverFin();
    }

    /**
     * L'épaisseur du trait qui sera gravé.
     * */
    public void graverMoyen()
    {
        trait = this.trait.graverMoyen();
    }

    /**
     * L'épaisseur du trait qui sera gravé.
     * */
    public void graverEpais()
    {
        trait = this.trait.graverEpais();
    }

    /**
     * Si il y a un seul trou de percée dans la diagonale et rien d'autre on ne la considère pas comme usinée.
     * @return La diagonal est usinée.
     * */
    public boolean estUsine()
    {
        return !(trou == Trou.Rien || trou == Trou.Un) && trait != Trait.Rien;
    }

    /**
     * @param autre
     * La diagonal à laquelle on veut la comparer
     * @return Les diagonales ont le même usinage.
     * */
    public boolean comparer(Diagonal autre)
    {

    	if (autre == this)
        {
    		return true;
    	}
        return this.trou == autre.trou && this.trait == autre.trait;
    }

    @Override
    public String toString()
    {
        return trait + " " + trou;
    }

}
