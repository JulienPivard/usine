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

public class TestDiagonal
{

    private Diagonal diag;

    @Before
    public void initialisation()
    {
        diag = new Diagonal();
        assertNotNull("La diagonal doit exister.", diag);
    }

    @Test
    public void testVide()
    {
        assertTrue("Il n'y a pas de trait sur la diagonal.", diag.peutGraver(Trait.Fin));
        assertTrue("Il n'y a pas de trou.", diag.percageUtile(Trou.Un));
    }

    @Test
    public void percerGraver()
    {
        diag.percerUn();
        assertFalse("Il y a un trou, on ne doit pas pouvoir percer avec Un.", diag.percageUtile(Trou.Un));
        assertSame("La diagonal doit avoir :", Trou.Un, diag.getPercage());
        assertTrue("Il n'y a pas de trait sur la diagonal.", diag.peutGraver(Trait.Fin));
        assertTrue("Il y a un trou.", diag.percageUtile(Trou.Deux));
        diag.graverFin();
        assertFalse("Il y a une gravure fine sur la diagonal on ne doit pas pouvoir graver.", diag.peutGraver(Trait.Fin));
        assertTrue("Il y a une gravure fine sur la diagonal.", diag.peutGraver(Trait.Epais));
        assertSame("La gravure de la diagonal doit être :", Trait.Fin, diag.getGravure());
    }
}
