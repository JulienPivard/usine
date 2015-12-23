package usine.vue;

import java.awt.Dimension;
import java.net.URL;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Affiche une image correspondant au verdict.
 * @author PIVARD Julien, CLECH Sandy
 */
public class VueVerdict extends JLabel {

	private static final long serialVersionUID = -8359975548059177371L;

	/**
	 * La vue de l'application.
	 */
	protected Vue vue;

	/**
	 * Associe un verdict vrai ou faux à une image.
	 */
	protected static final HashMap< Boolean, ImageIcon > imagesVerdict;
    static {
    	imagesVerdict = new HashMap< Boolean, ImageIcon >();
		ClassLoader loader = VueChaineProduction.class.getClassLoader();
		{
		    URL url = loader.getResource(Vue.cheminImages + "non.png");
		    imagesVerdict.put(false, new ImageIcon(url));
		}
		{
		    URL url = loader.getResource(Vue.cheminImages + "oui.png");
		    imagesVerdict.put(true, new ImageIcon(url));
		}
    }

	/**
	 * Contruit une représentation du verdict.
	 * @param vue la vue de l'application.
	 */
	public VueVerdict(Vue vue) {
		this.vue = vue;
		setBorder(BorderFactory.createTitledBorder("Verdict"));
		setPreferredSize(new Dimension(70,70));
		setHorizontalAlignment(CENTER);
		mettreAJour();
	}

	/**
	 * Met à jour l'image.
	 */
	public void mettreAJour() {
		final ImageIcon image = lireImageVerdict();
		setIcon(image);
	}
	
	/**
	 * Récupère l'image correspondant au verdict.
	 * @return l'image correspondant au verdict.
	 */
	protected ImageIcon lireImageVerdict() {
		boolean verdict = vue.lirePresentateur().getVerdict();
		return imagesVerdict.get(verdict);
	}
}
