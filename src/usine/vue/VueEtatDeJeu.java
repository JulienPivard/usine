package usine.vue;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Conteneur visuel pour les pièces et le verdict.
 * @author PIVARD Julien, CLECH Sandy
 */
public class VueEtatDeJeu extends JPanel {

	private static final long serialVersionUID = 1251465405785933773L;
	
	/**
	 * Vue de l'application.
	 */
	protected final Vue vue;
	
	/**
	 * Affichage de la pièce usinée.
	 */
	protected VuePiece vuePiece;

	/**
	 * Affichage de la pièce modèle.
	 */
	protected VuePiece vuePieceModele;

	/**
	 * Affichage du verdict.
	 */
	protected VueVerdict vueVerdict;

	/**
	 * Constructeur public
	 * @param vue la vue de l'application
	 */
	public VueEtatDeJeu(Vue vue) {
		this.vue = vue;

		{
			vuePieceModele = new VuePiece(vue.lirePresentateur().getModeleDePiece());
			
			BoutonDifficulte boutonDifficile = new BoutonDifficile(vue);
			BoutonDifficulte boutonMoyen = new BoutonMoyen(vue);
			BoutonDifficulte boutonFacile = new BoutonFacile(vue);
			
			final JPanel panelPieceModele = new JPanel();
			panelPieceModele.add(vuePieceModele);
			panelPieceModele.add(boutonFacile);
			panelPieceModele.add(boutonMoyen);
			panelPieceModele.add(boutonDifficile);
			panelPieceModele.setBorder(BorderFactory.createTitledBorder("Modèle"));
			add(panelPieceModele, BorderLayout.EAST);
		}
		
		vueVerdict = new VueVerdict(vue);
		add(vueVerdict, BorderLayout.CENTER);
		
		{
			vuePiece = new VuePiece(vue.lirePresentateur().getPiece());
			final JPanel panelPiece = new JPanel();
			panelPiece.add(vuePiece);
			panelPiece.setBorder(BorderFactory.createTitledBorder("Pièce usinée"));
			add(panelPiece, BorderLayout.EAST);
		}

	}
	
	/**
	 * Met à jour l'affichage
	 */
	public void mettreAJour() {
		vuePieceModele.mettreAJour();
		vueVerdict.mettreAJour();
		vuePiece.mettreAJour();
	}
}
