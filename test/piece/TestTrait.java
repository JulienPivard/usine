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

/**
 * @author PIVARD Julien
 */
public class TestTrait
{

    private Trait trait;

    @Before
    public void initialisation()
    {
        trait = Trait.Rien;
    }

    @Test
    public void testRien()
    {
        assertSame("Taille de trait attendu :", Trait.Rien, trait);
        assertTrue("L'usinage doit être possible :", trait.peutGraver(Trait.Fin));
        assertFalse("L'usinage doit être impossible :", trait.peutGraver(Trait.Rien));
    }

    @Test
    public void testFin()
    {
        trait = trait.graverFin();
        assertSame("Le trait doit être :", Trait.Fin, trait);
        assertTrue("L'usinage doit être possible :", trait.peutGraver(Trait.Moyen));
        assertFalse("L'usinage doit être impossible :", trait.peutGraver(Trait.Fin));
        trait = trait.graverFin();
        assertSame("Le trait doit être :", Trait.Fin, trait);
        assertTrue("L'usinage doit être possible 1 :", trait.peutGraver(Trait.Moyen));
        assertFalse("L'usinage doit être impossible 1 :", trait.peutGraver(Trait.Fin));
    }

    @Test
    public void testEpais()
    {
        trait = trait.graverEpais();
        assertSame("Le trait doit être :", Trait.Epais, trait);
        assertFalse("L'usinage doit être impossible avec moyen :", trait.peutGraver(Trait.Moyen));
        assertFalse("L'usinage doit être impossible avec epais :", trait.peutGraver(Trait.Epais));
        trait = trait.graverMoyen();
        assertSame("Le trait doit être :", Trait.Epais, trait);
        assertFalse("L'usinage doit être impossible avec moyen 1 :", trait.peutGraver(Trait.Moyen));
        assertFalse("L'usinage doit être impossible avec epais 1 :", trait.peutGraver(Trait.Epais));
    }

}
