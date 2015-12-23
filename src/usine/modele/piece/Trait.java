package usine.modele.piece;

/**
 * Représente la gravure d'un trait d'épaisseur donnée.
 * @author PIVARD Julien, CLECH Sandy
 */
public enum Trait
{
    Rien,
    Fin,
    Moyen,
    Epais;

    /**
     * @return La gravure que l'on veut réaliser est plus épaisse que la gravure actuel
     * */
    public boolean peutGraver(Trait trait)
    {
        return this.ordinal()<trait.ordinal();
    }

    /**
     * @return L'une des 4 taille gravures aléatoirement.
     * */
    public Trait tailleGravureAleatoire()
    {
        return values()[(int)(Math.random() * 4)];
    }

    /**
     * Permet de graver un trait Fin seulement si la gravure précédente était rien.
     * @return La nouvelle gravure si on peut graver sinon la même.
     * */
    public Trait graverFin()
    {
        if(peutGraver(Trait.Fin))
        {
            return Trait.Fin;
        }
        return this;
    }

    /**
     * Permet de graver un trait de taille moyenne seulement si la gravure précédente est rien ou fine.
     * @return La nouvelle gravure si on peut graver sinon la même.
     * */
    public Trait graverMoyen()
    {
        if(peutGraver(Trait.Moyen))
        {
            return Trait.Moyen;
        }
        return this;
    }

    /**
     * Permet de graver un trait de taille épaisse seulement si la gravure précédente est de taille moyenne fine ou rien.
     * @return La nouvelle gravure si on peut graver sinon la même.
     * */
    public Trait graverEpais()
    {
        if(peutGraver(Trait.Epais))
        {
            return Trait.Epais;
        }
        return this;
    }
}
