package usine.vue;

import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.KeyStroke;

/**
 * Classe representant une action abstraite, c'est a dire une action commune
 * a une barre de menus et d'outils.
 */
abstract class ActionAbstraite extends AbstractAction {

	private static final long serialVersionUID = -6988215295333721270L;

	/**
     * Constructeur logique.
     *
     * @param nom le nom de l'entree.
     * @param icone l'icone de l'entree.
     * @param bulleAide la bulle d'aide qui apparait lorsque la souris s'attarde
     *   sur l'entree.
     * @param mnemonique la mnemonique de l'entree.
     * @param accelerateur la sequence de touches du clavier permettant de
     *   selectionner l'action
     * @param vue la valeur de {@link ActionAbstraite#vue}.
     */
    public ActionAbstraite(String nom, 
			   Icon icone,
			   String bulleAide,
			   int mnemonique,
			   KeyStroke accelerateur,
			   Vue vue) {
		super(nom, icone);
		putValue(Action.SHORT_DESCRIPTION, bulleAide);
		putValue(Action.MNEMONIC_KEY, mnemonique);
		putValue(Action.ACCELERATOR_KEY, accelerateur);
		this.vue = vue;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link ActionAbstraite#vue}.
     */
    public Vue lireVue() {
		return vue;
    }

    /**
     * La vue proprietaire de cette action.
     */
    protected Vue vue;

}