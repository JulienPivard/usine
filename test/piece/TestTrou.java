import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.Before;
import junit.framework.*;

import usine.modele.piece.Trou;

/**
 * @author PIVARD Julien
 */
public class TestTrou
{

    private Trou trou;

    @Before
    public void initialisation()
    {
        trou = Trou.Rien;
    }

    @Test
    public void testRien()
    {
        assertSame("Il doit y avoir : ", Trou.Rien, trou);
        assertTrue("Le perçage doit être utile :", trou.percageUtile(Trou.Un));
        assertFalse("Le perçage doit être inutile :", trou.percageUtile(Trou.Rien));
    }

    @Test
    public void testun()
    {
        trou = trou.percerUn();
        assertSame("Il doit y avoir : ", Trou.Un, trou);

        assertFalse("Le perçage doit être inutile :", trou.percageUtile(Trou.Un));
        assertTrue("Le perçage doit être utile :", trou.percageUtile(Trou.Deux));
    }

    @Test
    public void testTrois()
    {
        trou = trou.percerDeux();
        assertSame("Il doit y avoir 2 :", Trou.Deux, trou);
        trou = trou.percerUn();
        assertSame("Il doit y avoir 3 :", Trou.Trois, trou);
        assertFalse("On ne peut pas percer :", trou.percageUtile(Trou.Deux));
    }

}
