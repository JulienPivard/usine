package usine.vue;

import java.awt.event.ActionEvent;

/**
 * Bouton pour changer la difficulté en Difficile.
 * @author PIVARD Julien, CLECH Sandy
 */
public class BoutonDifficile extends BoutonDifficulte
{

	private static final long serialVersionUID = 5701180742490718314L;

	/**
	 * Constructeur public.
	 * @param vue la vue de l'application
	 */
	public BoutonDifficile(Vue vue)
    {
		super(vue, "Difficile");
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
    {
		vue.cbDifficulteDifficile();
	}

}
