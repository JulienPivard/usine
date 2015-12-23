package usine.modele.piece;

/**
 * Représente un nombre de trous.
 * @author PIVARD Julien, CLECH Sandy
 */
public enum Trou
{
    Rien,
    Un
    {
        /**
         * Cas particulier une diagonal qui n'est pas encore usinée peut posséder un trou il faut donc tenir compte de ce cas et ne pas remettre la diagonal à rien.
         * @return Le perçage effectué ne peut pas retourner rien car il y a déjà un trou.
         * */
        @Override
        public Trou nbTrouAleatoire()
        {
            Trou t;
            do
            {
                t = super.nbTrouAleatoire();
            }
            while(t==Rien);
            if(t==Deux)
            {
                return Trois;
            }
            return t;
        }
    },
    Deux,
    Trois;

    /**
     * @return Le trou n'est pas déjà percé:
     * <ul>
     *  <li>faux si on essaye de percer le même trou; </li>
     *  <li>faux si on essaye de percer avec Rien; </li>
     *  <li>faux si on les 3 trous sont déjà percé. </li>
     * </ul>
     * */
    public boolean percageUtile(Trou trou)
    {
        return this!=trou && trou!=Trou.Rien && this!=Trou.Trois;
    }

    /**
     * @return L'un des 4 perçage aléatoirement.
     * */
    public Trou nbTrouAleatoire()
    {
        return values()[(int)(Math.random() * 4)];
    }

    /**
     * Percer un trou de plus dans la pièce.
     * @return Le type de trou résultant du perçage;
     * */
    public Trou percerUn()
    {
        if(percageUtile(Trou.Un))
        {
            return values()[this.ordinal() + Trou.Un.ordinal()];
        }
        return this;
    }

    /**
     * Percer deux trous de plus dans la pièce.
     * @return Le type de trou résultant du perçage;
     * */
    public Trou percerDeux()
    {
        if(percageUtile(Trou.Deux))
        {
            return values()[this.ordinal() + Trou.Deux.ordinal()];
        }
        return this;
    }

    /**
     * Percer trois trous dans la pièce.
     * @return Le type de trou résultant du perçage;
     * */
    public Trou percerTrois()
    {
        if(percageUtile(Trou.Trois))
        {
            return Trou.Trois;
        }
        return this;
    }

}
