package usine.vue;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

import usine.modele.piece.Diagonal;
import usine.modele.piece.Piece;
import usine.modele.piece.Trou;

/**
 * Représentation graphique d'une pièce de l'usine.
 * @author PIVARD Julien, CLECH Sandy
 */
public class VuePiece extends JPanel {
	/**
	 * Rayon du cercle circonscrit à l'octogone.
	 */
	protected static final double r = 30;
	/**
	 * Demi-côté de l'octogone.
	 */
	protected static final double c = r * Math.sin(Math.PI / 8);
	/**
	 * Apothème (m'voyez) de l'octogone.
	 */
	protected static final int h = (int) (c / Math.atan(Math.PI / 8));
	/**
	 * Taille du cadre.
	 */
	protected static final double L = 3 * 2 * c;
	/**
	 * Taille d'un trou.
	 */
	protected static final int tailleTrou = (int) (r / 3);

	private static final long serialVersionUID = 3495000745768472335L;

	/**
	 * Pièce représentée dans le canvas.
	 */
	protected Piece piece;
	
	/**
	 * Créé une nouvelle vue de pièce.
	 * @param piece la pièce à afficher.
	 */
	public VuePiece(Piece piece) {
		this.piece = piece;
		setPreferredSize(new Dimension(200,200));
	}
	
	/**
	 * Dessiner un trou dans le canvas
	 * @param g2d l'objet Graphics2D
	 */
	protected void dessinerTrou(Graphics2D g2d, int x) {
		g2d.setColor(getBackground());
		g2d.fillOval(x-tailleTrou/2, -tailleTrou/2, tailleTrou, tailleTrou);
		g2d.setColor(Color.BLACK);
		g2d.drawOval(x-tailleTrou/2, -tailleTrou/2, tailleTrou, tailleTrou);
	}
	
	/**
	 * Dessiner une diagonale dans le canvas
	 * @param g2d l'objet Graphics2D
	 */
	protected void dessinerDiagonale(Graphics2D g2d, Diagonal d) {
		// Dessin des gravures en noir à la bonne taille
		
		g2d.setColor(Color.BLACK);
		switch(d.getGravure()) {
		case Epais:
			g2d.setStroke(new BasicStroke(2));
			g2d.drawLine(-(int)h, 0, (int)h, 0);
			break;
		case Moyen:
			g2d.setStroke(new BasicStroke(1));
			g2d.drawLine(-(int)h, 0, (int)h, 0);
			break;
		case Fin:
			g2d.setStroke(new BasicStroke(0));
			g2d.drawLine(-(int)h, 0, (int)h, 0);
			break;
		default:
			break;
		}
		
		// Dessin des trous transparents avec le tour noir
		g2d.setStroke(new BasicStroke(0));
		if(d.getPercage() == Trou.Deux || d.getPercage() == Trou.Trois) {
			dessinerTrou(g2d, -h/2);

			dessinerTrou(g2d, h/2);
		}
		if(d.getPercage() == Trou.Un || d.getPercage() == Trou.Trois) {
			dessinerTrou(g2d, 0);
		}
	}
	
	/**
	 * Dessiner la pièce dans le canvas
	 * @param g2d l'objet Graphics2D
	 */
	protected void dessinerPiece(Graphics2D g2d) {
		// Dessin des tours de la pièce
		int xPoly[] = new int[8];
		int yPoly[] = new int[8];
		for(int i = 0; i < 8; i++) {
			xPoly[i] = (int) (r * Math.cos(Math.PI / 8 + i * Math.PI / 4));
			yPoly[i] = (int) (r * Math.sin(Math.PI / 8 + i * Math.PI / 4));
		}
		g2d.setStroke(new BasicStroke(3));
		g2d.drawPolygon(new Polygon(xPoly, yPoly, 8));

		// Dessin des diagonales
		final Diagonal[] diagonales = piece.getDiagonales();
		final int d = piece.getIndiceDiagonalCourante();
		for(int i = 0; i < 4; i++) {
			dessinerDiagonale(g2d, diagonales[(d+i)%4]);
			g2d.rotate(Math.PI/4);
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	    final int width = getWidth();	
	    final int height = getHeight(); 
		final double scale = Math.min(width, height)/L;
		
	    final Graphics2D g2d = (Graphics2D)g;
		g2d.translate(width/2, height/2);
		g2d.scale(scale, scale);
		
		dessinerPiece(g2d);
	}

	/**
	 * Réaffiche la pièce.
	 */
	public void mettreAJour() {
		repaint();
	}
}
