// let b:syntastic_checkers = ""

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestTrait.class, TestTrou.class, TestDiagonal.class, TestPiece.class, TestModelePiece.class})
/**
 * Suite de test
 * @author PIVARD Julien
 */
public class TestSuite
{
}
