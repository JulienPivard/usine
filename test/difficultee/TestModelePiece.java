import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.Before;
import junit.framework.*;

import usine.modele.difficultee.*;

/**
 * @author PIVARD Julien
 */
public class TestModelePiece
{
    private ModeleDePiece modele;
    private DifficulteeAbstraite dif;

    @Before
    public void init()
    {
        FabriqueDifficultes f = new FabriqueDifficultes();
        dif = f.faireFacile();
        modele = new ModeleDePiece(dif);
    }

    @Test
    public void verifInit()
    {
        assertNotNull("Une difficulté :", dif);
        assertNotNull("Un modelé de pièce :", modele);
    }

    @Test
    public void testFacile()
    {
        assertSame("La difficulté stocké dans le modèle :", dif, modele.getDifficulte());
        System.out.println("Avant la production : " + modele);
        modele.produire();
        System.out.println("Après la production : " + modele);
    }
}
