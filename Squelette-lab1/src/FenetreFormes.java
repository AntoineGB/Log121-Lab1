
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * Cette fenêtre gère l'affichage des formes
 * 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent {

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500, 500);

	private Formes[] tabFormes;

	/**
	 * Constructeur
	 */
	public FenetreFormes() {
		tabFormes = new Formes[10];
	}

	/*
	 * Affiche la liste de formes
	 */
	@Override
	public void paintComponent(Graphics g) {

		for (int i = 0; i <= 9; i++) {
			if (tabFormes[i] != null) {
				tabFormes[i].paintComponent(g);
			}
		}
	}

	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver l'espace
	 * nécessaire à son affichage
	 */
	@Override
	public Dimension getPreferredSize() {
		return dimension;
	}

	/**
	 *  Rajoute une nouvelle fomre dans le tableau.  Si le tableau est remplit, il suprimme la premi�re forme dans le tableau
	 *  et rajoute la nouvelle forme � la fin du tableau
	 * @param forme
	 * 				Nouvelle forme a rajouter dans le tableau
	 */
	public void ajouterForme(Formes forme) {
		if (tabFormes[9] != null) {
			for (int i = 1; i <tabFormes.length; i++) {
				tabFormes[i - 1] = tabFormes[i];
			}
			tabFormes[9] = forme;
		} else {
			boolean bool = true;
			for (int i = 0; i <tabFormes.length; i++) {
				if (tabFormes[i] == null && bool) {
					tabFormes[i] = forme;
					bool = false;
				}
			}
		}
	}

	/**
	 *  Vide le tableau de formes
	 */
	public void reset() {
		for (int i = 0; i <tabFormes.length; i++) {
			tabFormes[i] = null;
		}
	}
}
