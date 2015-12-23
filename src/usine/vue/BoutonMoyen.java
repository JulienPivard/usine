package usine.vue;

import java.awt.event.ActionEvent;

/**
 * Bouton pour changer la difficulté en Moyen.
 * @author PIVARD Julien, CLECH Sandy
 */
public class BoutonMoyen extends BoutonDifficulte {

	private static final long serialVersionUID = -2893211341438333552L;

	/**
	 * Constructeur public.
	 * @param vue la vue de l'application
	 */
	public BoutonMoyen(Vue vue) {
		super(vue, "Moyen");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		vue.cbDifficulteMoyenne();
	}	

}
