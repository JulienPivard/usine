package usine.modele.piece;

/**
 * Une pièce se compose de 4 diagonales vierges que l'ont peut usiner de deux manières :
 * <ul>
 *  <li> Percer;</li>
 *  <li> Graver.</li>
 * </ul>
 * On peut également faire pivoter la pièce, pour changer la diagonal courante.
 * La diagonal courante est celle qui sera usinée.
 * @author PIVARD Julien, CLECH Sandy
 */
public class Piece
{

    /**
     * Tableau des 4 diagonales de la pièce :
     * <ul>
     *  <li>1ere case : 0 degrés;</li>
     *  <li>2eme case : 45 degrés;</li>
     *  <li>3eme case : 90 degrés;</li>
     *  <li>4eme case : 135 degrés.</li>
     * </ul>
     * */
    protected Diagonal diagonales[] = new Diagonal[4];

    /**
     * Indique la diagonal courante
     * */
    protected int diagonalCourante;

    /**
     * Modifie la diagonal courante.
     * @return La diagonal à été changé.
     * */
    protected boolean pivoter(int nombreDeDiagonal)
    {
        diagonalCourante = (diagonalCourante + nombreDeDiagonal) % 4;
        return true;
    }

    /**
     * Créer une pièce avec des diagonales vierge.
     * */
    public Piece()
    {
        diagonalCourante = 0;
        for(int i=0; i<diagonales.length; i++)
        {
            diagonales[i] = new Diagonal();
        }
    }

    /**
     * @return La diagonal courante.
     * */
    public Diagonal getDiagonalCourante()
    {
        return diagonales[diagonalCourante];
    }

    /**
     * @return L'indice de la diagonal courante.
     * */
    public int getIndiceDiagonalCourante()
    {
        return diagonalCourante;
    }

    /**
     * Remet les diagonales de la pièce à zéro.
     * */
    public void reinitialiserDiagonales()
    {
        diagonalCourante = 0;
        for(Diagonal d : diagonales)
        {
            d.reinitialiser();
        }
    }

    /**
     * @return Le tableau des diagonales de la pièce.
     * */
    public Diagonal[] getDiagonales()
    {
        return diagonales;
    }

    /**
     * Ajoute un trou à la diagonal courante (si il n'y a rien ou deux trous).
     * @return Le perçage a eu lieu
     * */
    public boolean percerUn()
    {
        //Si on perce 1 trou, ce trou se trouve sur toutes les diagonales à la fois.
        boolean percer = getDiagonalCourante().percageUtile(Trou.Un);
        for(Diagonal diagonal : diagonales)
        {
            diagonal.percerUn();
        }
        return percer;
    }

    /**
     * Ajoute deux trous à la diagonal courante (si il n'y a rien ou un trou).
     * @return Le perçage a eu lieu
     * */
    public boolean percerDeux()
    {
        boolean percer = getDiagonalCourante().percageUtile(Trou.Deux);
        getDiagonalCourante().percerDeux();
        return percer;
    }

    /**
     * Perce trois trous dans la diagonal courante (si il n'y a rien, un ou deux trous).
     * @return Le perçage a eu lieu
     * */
    public boolean percerTrois()
    {
        boolean percer = getDiagonalCourante().percageUtile(Trou.Trois);
        getDiagonalCourante().percerTrois();
        //Si on perce 3 trous, le trou du milieu se trouve sur toutes les diagonales à la fois.
        this.percerUn();
        return percer;
    }

    /**
     * Grave un trait fin sur la diagonal courante.
     * @return La gravure a eu lieu
     * */
    public boolean graverFin()
    {
        boolean graver = getDiagonalCourante().peutGraver(Trait.Fin);
        getDiagonalCourante().graverFin();
        return graver;
    }

    /**
     * Grave un trait moyen sur la diagonal courante.
     * @return La gravure a eu lieu
     * */
    public boolean graverMoyen()
    {
        boolean graver = getDiagonalCourante().peutGraver(Trait.Moyen);
        getDiagonalCourante().graverMoyen();
        return graver;
    }

    /**
     * Grave un trait épais sur la diagonal courante.
     * @return La gravure a eu lieu
     * */
    public boolean graverEpais()
    {
        boolean graver = getDiagonalCourante().peutGraver(Trait.Epais);
        getDiagonalCourante().graverEpais();
        return graver;
    }

    /**
     * Fait pivoter la pièce de 45 degrés.
     * @return La rotation a été faite
     * */
    public boolean pivoter45()
    {
        return pivoter(1);
    }

    /**
     * Fait pivoter la pièce de 90 degrés.
     * @return La rotation a été faite
     * */
    public boolean pivoter90()
    {
        return pivoter(2);
    }

    /**
     * Fait pivoter la pièce de 135 degrés.
     * @return La rotation a été faite
     * */
    public boolean pivoter135()
    {
        return pivoter(3);
    }

    /**
     * Compare les diagonales de la pièce
     * @param autre
     * La pièce a comparer avec celle ci
     * @return La suite des 4 diagonales est la même pour les deux pièces.
     * */
    private boolean comparerDiagonalDecalee(Piece autre, int decalage)
    {
        for(int i=0; i<diagonales.length; i++)
        {
            if(!this.diagonales[(decalage + i) % 4].comparer(autre.diagonales[i])) { return false; }
        }
        return true;
    }

    /**
     * @param autre
     * La pièce à comparer avec celle ci
     * @return Les pièces ont les même suite de diagonales à une rotation prés.
     * */
    public boolean comparer(Piece autre)
    {
        if(autre==this){ return true; }
        // Vérification des valeurs des attributs
        int decalage = 0;
        for(int i=0; i<diagonales.length; i++)
        {
            if(this.comparerDiagonalDecalee(autre, decalage)) { return true; }
            decalage ++;
        }
        return false;
    }

    /**
     * Surtout présent pour le débogage en ligne de commande, le numéro de la diagonal est à gauche des crochets.
     * @return L'état des diagonales en partant de la diagonal courante.
     * */
    @Override
    public String toString()
    {
        String diag = "";
        for(int i = diagonalCourante; i < (diagonalCourante + 4); i++)
        {
            diag += "(" + i%4 + ")[ " + diagonales[i % 4] + " ] ";
        }
        return diag;
    }

}
