package usine.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Bouton pour changer la difficulté.
 * @author PIVARD Julien, CLECH Sandy
 */
public abstract class BoutonDifficulte extends JButton implements ActionListener {

	private static final long serialVersionUID = -4850539177829967855L;
	
	/**
	 * La vue de l'application.
	 */
	protected Vue vue;
	
	/**
	 * Constructeur public.
	 * @param vue la vue de l'application
	 */
	public BoutonDifficulte(Vue vue, String texte) {
		super(texte);
		this.vue = vue;
		addActionListener(this);
	}

	public abstract void actionPerformed(ActionEvent arg0);
}
