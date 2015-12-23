package usine.vue;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.Action;

/**
 * Classe representant une action permettant de presenter l'application,
 * sa version et ses auteurs.
 */
class ActionAPropos extends ActionAbstraite {

	private static final long serialVersionUID = 4877803982429735898L;

	/**
     * Constructeur logique.
     *
     * @param vue la valeur de {@link ActionAbstraite#vue}.
     */
    public ActionAPropos(Vue vue)
    {
        super(texte, icone, aide, mnemonique, accelerateur, vue);
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        JOptionPane.showMessageDialog(vue, message, (String)getValue(Action.NAME), JOptionPane.INFORMATION_MESSAGE, (ImageIcon)getValue(Action.SMALL_ICON));
    }

    /**
     * Texte de cette action.
     */
    protected static final String texte = "A propos ...";

    /**
     * Chemin d'acces relatif a l'icone de cette action.
     */
    protected static final String cheminIcone =
    	Vue.cheminImages + "a-propos.png";

    /**
     * Icone de cette action.
     */
    protected static final ImageIcon icone;
    static {
	ClassLoader loader = ActionAPropos.class.getClassLoader();
	URL url = loader.getResource(cheminIcone);
	icone = new ImageIcon(url);
    }

    /**
     * Texte de la bulle d'aide de cette action.
     */
    protected static final String aide =
	"Présente l'application, sa version et ses auteurs.";

    /**
     * Mnemonique de cette action.
     */
    protected static final int mnemonique = KeyEvent.VK_P;

    /**
     * Accelerateur de cette action.
     */
    protected static final KeyStroke accelerateur =
    	KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK);

    /**
     * Message de presentation de cette action.
     */
    protected final String message = "L'usine de Jean 1.0\n" +
	"Jeu de logique sur fond de révolution industrielle\n\n" +
	"Julien PIVARD\n" +
	"Sandy CLECH";

}
