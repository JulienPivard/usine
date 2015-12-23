package usine.vue;

import java.awt.event.ActionEvent;

/**
 * Bouton pour changer la difficulté en Facile.
 * @author PIVARD Julien, CLECH Sandy
 */
public class BoutonFacile extends BoutonDifficulte {

	private static final long serialVersionUID = -4149292133061676312L;

	/**
	 * Constructeur public.
	 * @param vue la vue de l'application
	 */
	public BoutonFacile(Vue vue) {
		super(vue, "Facile");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		vue.cbDifficulteFacile();
	}	

}
