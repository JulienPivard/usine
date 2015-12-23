package usine.modele.machines;

import usine.modele.piece.Piece;

/**
 * Énumération des différentes machines.
 * @author PIVARD Julien, CLECH Sandy
 */
public enum Machine
{

    PosteVide
    {
        /**
         * @param piece
         * La pièce à usiner
         * @return La pièce à été usinée.
         * */
        public boolean usiner(Piece piece)
        {
            return false;
        }
    },

    GraveuseFin
    {
        /**
         * @param piece
         * La pièce à usiner
         * @return La pièce à été usinée.
         * */
        public boolean usiner(Piece piece)
        {
            return piece.graverFin();
        }
    },
    GraveuseMoyen
    {
        /**
         * @param piece
         * La pièce à usiner
         * @return La pièce à été usinée.
         * */
        public boolean usiner(Piece piece)
        {
            return piece.graverMoyen();
        }
    },

    GraveuseLarge
    {
        /**
         * @param piece
         * La pièce à usiner
         * @return La pièce à été usinée.
         * */
        public boolean usiner(Piece piece)
        {
            return piece.graverEpais();
        }
    },

    Perceuse1
    {
        /**
         * @param piece
         * La pièce à usiner
         * @return La pièce à été usinée.
         * */
        public boolean usiner(Piece piece)
        {
            return piece.percerUn();
        }
    },

    Perceuse2
    {
        /**
         * @param piece
         * La pièce à usiner
         * @return La pièce à été usinée.
         * */
        public boolean usiner(Piece piece)
        {
            return piece.percerDeux();
        }
    },

    Perceuse3
    {
        /**
         * @param piece
         * La pièce à usiner
         * @return La pièce à été usinée.
         * */
        public boolean usiner(Piece piece)
        {
            return piece.percerTrois();
        }
    },

    Tourneuse45
    {
        /**
         * @param piece
         * La pièce à usiner
         * @return La pièce à été usinée.
         * */
        public boolean usiner(Piece piece)
        {
            return piece.pivoter45();
        }
    },

    Tourneuse90
    {
        /**
         * @param piece
         * La pièce à usiner
         * @return La pièce à été usinée.
         * */
        public boolean usiner(Piece piece)
        {
            return piece.pivoter90();
        }
    },

    Tourneuse135
    {
        /**
         * @param piece
         * La pièce à usiner
         * @return La pièce à été usinée.
         * */
        public boolean usiner(Piece piece)
        {
            return piece.pivoter135();
        }
    };

    public abstract boolean usiner(Piece piece);


    /**
     * retourne la machine suivante
     * @return
     * la machine suivante.
     */
    public Machine machineSuivante(){
    	Machine[] listeMachines = Machine.values();
    	return listeMachines[(ordinal() + 1) % listeMachines.length];
    }

}
