package usine.vue;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

import usine.presentateur.Presentateur;

/**
 * Fenêtre principale de l'application.
 * @author CLECH Sandy
 */
public class Vue extends JFrame {

	private static final long serialVersionUID = -3760698079241388695L;

	/**
	 * Titre de la fenêtre.
	 */
	protected String titre = "L'usine de Jean";

	/**
	 * Présentateur du MVP.
	 */
	protected Presentateur presentateur;

	/**
	 * Affichage de la chaîne de production.
	 */
	protected VueChaineProduction vueChaineProduction;

    /**
     * Action permettant de quitter proprement l'application.
     */
	protected final ActionQuitter actionQuitter;

	/**
	 * Représentation des deux pièces et du verdict.
	 */
	protected VueEtatDeJeu vueEtatDeJeu;

	/**
	 * Chemin du dossier d'images.
	 */
	public static final String cheminImages = "ressources/images/";

	/**
	 * Constructeur de la Vue
	 * @param presentateur
	 */
	public Vue(Presentateur presentateur){
		this.presentateur = presentateur;

		setLocationRelativeTo(null);
		setTitle(titre);

		actionQuitter = new ActionQuitter(this);
		contruireBarresMenusEtOutils();

		vueChaineProduction = new VueChaineProduction(this);
		vueEtatDeJeu = new VueEtatDeJeu(this);

		add(vueChaineProduction, BorderLayout.CENTER);
		add(vueEtatDeJeu, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				actionQuitter.dernierArretAvantSortie();
			}
		});
	}

    /**
     * Construit la barre de menus et d'outils et les implante a la position
     * nord du gestionnaire de mise en forme par defaut.
     */
	protected void contruireBarresMenusEtOutils() {
		// Instanciation des barres de menus et d'outils.
		final JMenuBar barreMenus = new JMenuBar();
		final JToolBar barreOutils = new JToolBar();

		// Creation du menu et definition de sa mnemonique.
		final JMenu menu = new JMenu("Commandes");
		menu.setMnemonic('C');

		// Instanciation de l'action "A propos ..." puis ajout  dans le menu.
		final ActionAPropos actionAPropos = new ActionAPropos(this);
		menu.add(actionAPropos);

		// Implantation d'un separateur dans le menu.
		menu.addSeparator();

		// Ajout de l'action "Quitter" dans le menu.
		menu.add(actionQuitter);

		// Ajout de l'action "A propos ..." dans la barre d'outils.
		barreOutils.add(actionAPropos);

		// Ajout d'un separateur dans la barre d'outils.
		barreOutils.addSeparator();

		// Ajout de l'action "Quitter" dans la barre d'outils.
		barreOutils.add(actionQuitter);

		// Inscription du menu dans sa barre.
		barreMenus.add(menu);

		// Implantation de la barre de menus sous le titre de la fenetre.
		setJMenuBar(barreMenus);

		// Implantation de la barre d'outils dans le gestionnaire de mise en
		// forme par defaut.
		add(barreOutils, BorderLayout.NORTH);
	}

	/**
	 * Getter du presentateur
	 * @return Presentateur
	 */
	public Presentateur lirePresentateur() {
		return presentateur;
	}

	/**
	 * met a jour l'icone de la machine suivante
	 * 
     * cette methode pose un verrou sur la vue pendant tout la duree
     *   de son execution.
	 * @param vueMachine
	 */
	protected synchronized void cbMachineSuivante(VueMachine vueMachine){
		presentateur.machineSuivante(vueMachine.getPlace());
		vueMachine.mettreAJour();
		vueEtatDeJeu.mettreAJour();
	}

	/**
	 * Recréé une partie avec la nouvelle difficulté.
	 * 
     * cette methode pose un verrou sur la vue pendant tout la duree
     *   de son execution.
	 */
	protected synchronized void cbDifficulteFacile(){
		presentateur.setDifficulteFacile();
		vueChaineProduction.mettreAJour();
		vueEtatDeJeu.mettreAJour();
	}

	/**
	 * Recréé une partie avec la nouvelle difficulté.
	 * 
     * cette methode pose un verrou sur la vue pendant tout la duree
     *   de son execution.
	 */
	protected synchronized void cbDifficulteMoyenne(){
		presentateur.setDifficulteMoyenne();
		vueChaineProduction.mettreAJour();
		vueEtatDeJeu.mettreAJour();
	}

	/**
	 * Recréé une partie avec la nouvelle difficulté.
	 * 
     * cette methode pose un verrou sur la vue pendant tout la duree
     *   de son execution.
	 */
	protected synchronized void cbDifficulteDifficile(){
		presentateur.setDifficulteDifficile();
		vueChaineProduction.mettreAJour();
		vueEtatDeJeu.mettreAJour();
	}

}
