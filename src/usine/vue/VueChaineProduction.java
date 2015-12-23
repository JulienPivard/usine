package usine.vue;

import java.awt.GridLayout;
import javax.swing.JPanel;


/**
 * Conteneur visuel de la chaîne de production.
 * @author PIVARD Julien, CLECH Sandy
 */
public class VueChaineProduction extends JPanel {

	private static final long serialVersionUID = -1979114804209627281L;
	
	/**
	 * Vue de l'application.
	 */
	protected final Vue vue;
	
	/**
	 * Tableau des vues de machines.
	 */
	protected final VueMachine[] machines ;
	
	/**
	 * Constructeur du modeleGraphique
	 * @param vue
	 */
	public VueChaineProduction(Vue vue) {
		this.vue = vue;
		
		setLayout(new GridLayout(2, 4, 0, 0));
		this.machines = new VueMachine[8];
		for(int i = 0; i < machines.length; i++){
			machines[i] = new VueMachine(this, i);
			add(machines[i]);
		}
	}
	
	/**
	 * Getter de la vue a laquelle appartient le ModeleGraphique
	 * @return Vue
	 */
	public Vue lireVue() {
		return vue;
	}
	
	/**
	 * Met à jour l'affichage de la chaîne de production
	 */
	public void mettreAJour() {
		for(int i = 0; i < machines.length; i++){
			machines[i].mettreAJour();
		}
	}
}
