import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.Before;
import junit.framework.*;

import usine.modele.piece.Trait;
import usine.modele.piece.Trou;
import usine.modele.piece.Diagonal;
import usine.modele.piece.Piece;

public class TestPiece
{

    private Piece piece;
    private Diagonal diags[];

    @Before
    public void initialiser()
    {
        piece = new Piece();
        assertNotNull("La pièce doit exister.", piece);
        diags = piece.getDiagonales();
    }

    @Test
    public void pieceVierge()
    {
        int i = 0;
        for(Diagonal d : diags)
        {
            assertSame("On tests le trou  de la diagonal : " + i + " :", d.getPercage(), Trou.Rien);
            assertSame("On tests le trait de la diagonal : " + i + " :", d.getGravure(), Trait.Rien);
            i = i++;
        }
    }

    @Test
    public void testPercerDeuxpuisUn()
    {
        piece.percerDeux();
        assertSame("On tests le trou  de la diagonal 0 :", Trou.Deux,  diags[0].getPercage());
        assertSame("On tests le trait de la diagonal 0 :", Trait.Rien, diags[0].getGravure());
        assertSame("On tests le trou  de la diagonal 1 :", Trou.Rien,  diags[1].getPercage());
        assertSame("On tests le trait de la diagonal 1 :", Trait.Rien, diags[1].getGravure());
        assertSame("On tests le trou  de la diagonal 2 :", Trou.Rien,  diags[2].getPercage());
        assertSame("On tests le trait de la diagonal 2 :", Trait.Rien, diags[2].getGravure());
        assertSame("On tests le trou  de la diagonal 3 :", Trou.Rien,  diags[3].getPercage());
        assertSame("On tests le trait de la diagonal 3 :", Trait.Rien, diags[3].getGravure());

        piece.percerUn();
        assertSame("On tests le trou  de la diagonal 0 :", Trou.Trois, diags[0].getPercage());
        assertSame("On tests le trait de la diagonal 0 :", Trait.Rien, diags[0].getGravure());
        assertSame("On tests le trou  de la diagonal 1 :", Trou.Un,    diags[1].getPercage());
        assertSame("On tests le trait de la diagonal 1 :", Trait.Rien, diags[1].getGravure());
        assertSame("On tests le trou  de la diagonal 2 :", Trou.Un,    diags[2].getPercage());
        assertSame("On tests le trait de la diagonal 2 :", Trait.Rien, diags[2].getGravure());
        assertSame("On tests le trou  de la diagonal 3 :", Trou.Un,    diags[3].getPercage());
        assertSame("On tests le trait de la diagonal 3 :", Trait.Rien, diags[3].getGravure());
    }

    @Test
    public void testPercerTrois()
    {
        piece.percerTrois();
        assertSame("On tests le trou  de la diagonal 0 :", Trou.Trois, diags[0].getPercage());
        assertSame("On tests le trait de la diagonal 0 :", Trait.Rien, diags[0].getGravure());
        assertSame("On tests le trou  de la diagonal 1 :", Trou.Un   , diags[1].getPercage());
        assertSame("On tests le trait de la diagonal 1 :", Trait.Rien, diags[1].getGravure());
        assertSame("On tests le trou  de la diagonal 2 :", Trou.Un   , diags[2].getPercage());
        assertSame("On tests le trait de la diagonal 2 :", Trait.Rien, diags[2].getGravure());
        assertSame("On tests le trou  de la diagonal 3 :", Trou.Un   , diags[3].getPercage());
        assertSame("On tests le trait de la diagonal 3 :", Trait.Rien, diags[3].getGravure());
    }

    @Test
    public void testGraver()
    {
        piece.percerTrois();
        piece.graverFin();
        assertSame("On tests le trou  de la diagonal 0 :", Trou.Trois, diags[0].getPercage());
        assertSame("On tests le trait de la diagonal 0 :", Trait.Fin , diags[0].getGravure());
        assertSame("On tests le trou  de la diagonal 1 :", Trou.Un   , diags[1].getPercage());
        assertSame("On tests le trait de la diagonal 1 :", Trait.Rien, diags[1].getGravure());
        assertSame("On tests le trou  de la diagonal 2 :", Trou.Un   , diags[2].getPercage());
        assertSame("On tests le trait de la diagonal 2 :", Trait.Rien, diags[2].getGravure());
        assertSame("On tests le trou  de la diagonal 3 :", Trou.Un   , diags[3].getPercage());
        assertSame("On tests le trait de la diagonal 3 :", Trait.Rien, diags[3].getGravure());
    }

    @Test
    public void pivoter()
    {
        piece.percerTrois();
        piece.graverFin();
        piece.pivoter45();
        piece.graverMoyen();
        assertSame("On tests le trou  de la diagonal 0 :", Trou.Trois , diags[0].getPercage());
        assertSame("On tests le trait de la diagonal 0 :", Trait.Fin  , diags[0].getGravure());
        assertSame("On tests le trou  de la diagonal 1 :", Trou.Un    , diags[1].getPercage());
        assertSame("On tests le trait de la diagonal 1 :", Trait.Moyen, diags[1].getGravure());
        assertSame("On tests le trou  de la diagonal 2 :", Trou.Un    , diags[2].getPercage());
        assertSame("On tests le trait de la diagonal 2 :", Trait.Rien , diags[2].getGravure());
        assertSame("On tests le trou  de la diagonal 3 :", Trou.Un    , diags[3].getPercage());
        assertSame("On tests le trait de la diagonal 3 :", Trait.Rien , diags[3].getGravure());

        piece.pivoter90();
        piece.graverEpais();
        assertSame("On tests le trou  de la diagonal 0 :", Trou.Trois , diags[0].getPercage());
        assertSame("On tests le trait de la diagonal 0 :", Trait.Fin  , diags[0].getGravure());
        assertSame("On tests le trou  de la diagonal 1 :", Trou.Un    , diags[1].getPercage());
        assertSame("On tests le trait de la diagonal 1 :", Trait.Moyen, diags[1].getGravure());
        assertSame("On tests le trou  de la diagonal 2 :", Trou.Un    , diags[2].getPercage());
        assertSame("On tests le trait de la diagonal 2 :", Trait.Rien , diags[2].getGravure());
        assertSame("On tests le trou  de la diagonal 3 :", Trou.Un    , diags[3].getPercage());
        assertSame("On tests le trait de la diagonal 3 :", Trait.Epais, diags[3].getGravure());
    }
}
