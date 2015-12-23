package usine.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import usine.modele.machines.Machine;

/**
 * Affiche une machine de la chaîne de production.
 * @author PIVARD Julien, CLECH Sandy
 */
public class VueMachine extends JButton implements ActionListener {
	private static final long serialVersionUID = 8928585182251027555L;

	/**
	 * Associe une machine à une image.
	 */
	protected static final HashMap< Machine, ImageIcon > imagesMachines;
    static {
		imagesMachines = new HashMap< Machine, ImageIcon >();
		ClassLoader loader = VueChaineProduction.class.getClassLoader();
		for (Machine m : Machine.values()){
		    URL url = loader.getResource(Vue.cheminImages + m.name() +".png");
		    imagesMachines.put(m, new ImageIcon(url));
		}
    }
	
	/**
	 * Widget de la chaîne de production.
	 */
	protected VueChaineProduction vueChaineProduction;
	
	/**
	 * Position de la machine dans la chaîne de production.
	 */
	protected int place;
	
	/**
	 * Constructeur de VueMachine
	 * @param modeleGraphique le widget de la chaîne de production.
	 * @param place la position de la machine dans la chaîne de production.
	 */
	public VueMachine(VueChaineProduction modeleGraphique, int place) {
		this.vueChaineProduction = modeleGraphique;
		this.place = place;
		setBorder(BorderFactory.createTitledBorder("Poste [" + Integer.toString(place) + "]"));
		setContentAreaFilled(false);
		addActionListener(this);
		mettreAJour();
	}
	
	/**
	 * Met à jour l'affichage des images.
	 */
	public void mettreAJour(){
		// Obtention de l'image du joueur courant.
		final ImageIcon image = lireImageMachine();

		// Mise a jour.
		setIcon(image);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		vueChaineProduction.lireVue().cbMachineSuivante(this);
	}
	
	/**
	 * retourne la place de la machine 
	 * @return la place de la machine
	 */
	public int getPlace(){
		return this.place;
	}

	/**
	 * retourne l'image correspondante a une machine donnée
	 * @return ImageIcon
	 */
	protected ImageIcon lireImageMachine() {
		return imagesMachines.get(vueChaineProduction.lireVue().lirePresentateur().getSlot(place).getMachine());
	}
	
}