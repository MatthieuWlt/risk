import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Font;
import javax.swing.*;

public class Menu {

	public static void main(String[] args) {
		StdDraw.setCanvasSize(1229, 576);
		StdDraw.setXscale(0.0, 120);/* INITIALISATION DE LA TAILLE DE LA FENETRE */
		StdDraw.setYscale(0.0, 110);

		StdDraw.clear(StdDraw.BLACK);/* AFFICHAGE INITIAL DU JEU */
		StdDraw.setPenColor(StdDraw.WHITE);

		Font currentFont = StdDraw.getFont();
		float size = 25;
		currentFont = currentFont.deriveFont(size);
		StdDraw.setFont(currentFont);

		StdDraw.text(55, 60, "RISK");
		StdDraw.text(55, 45, "Cliquez pour jouer");/* on invite le joueur à cliquer pour jouer */

		/* INITIALISATION DES CHOIX */
		int choix1 = 0;// cliquer pour atteindre le menu
		int choix2 = 0;// cliquer pour sélectionner le nombre de joueur
		int choix3 = 0;
		int choix4 = 0;
		int choix5 = 0;
		int choix6 = 0;
		Random rand = new Random();

		while (choix1 != 1) {
			if (StdDraw.isMousePressed()) { /* si l'utilisateur clique, alors le menu s'affiche CHOIX 1 */
				StdDraw.clear(StdDraw.WHITE); /* AFFICHAGE DE LA PAGE MENU */
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(60, 90, "MENU");
				StdDraw.text(60, 70, "Sélectionnez le nombre de joueur : ");
				StdDraw.text(60, 60, "2 joueurs");
				StdDraw.text(60, 50, "3 joueurs");
				StdDraw.text(60, 40, "4 joueurs");
				StdDraw.text(60, 30, "5 joueurs");
				StdDraw.text(60, 20, "6 joueurs");
				StdDraw.pause(500);

				while (choix2 != 1) {
					if (StdDraw.mousePressed()) {
						double x = StdDraw.mouseX();
						double y = StdDraw.mouseY();
						StdDraw.clear(StdDraw.WHITE);
						if (55 < y && y < 65) {
							StdDraw.text(55, 60, "Vous jouez à 2");
							choix3 = 2;
							StdDraw.pause(500);
							break;
						} else if (45 < y && y < 55) {
							StdDraw.text(55, 60, "Vous jouez à 3");
							choix3 = 3;
							StdDraw.pause(500);
							break;
						} else if (35 < y && y < 45) {
							StdDraw.text(55, 60, "Vous jouez à 4");
							choix3 = 4;
							StdDraw.pause(500);
							break;
						} else if (25 < y && y < 35) {
							StdDraw.text(55, 60, "Vous jouez à 5");
							choix3 = 5;
							StdDraw.pause(500);
							break;
						} else if (15 < y && y < 25) {
							StdDraw.text(55, 60, "Vous jouez à 6");
							choix3 = 6;
							StdDraw.pause(500);
							break;
						}

					} else {
						
					}
				}
				break;
			} else {
			} /* l'utilisateur ne clique pas, le menu ne s'affiche pas CHOIX 1 */
		}

		// 2 JOUEURS
		/*
		while (choix3 == 2) {
			if (StdDraw.isMousePressed()) {
				StdDraw.clear(StdDraw.WHITE);/* AFFICHAGE DE LA PAGE 
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(60, 90, "Joueur 1, choisissez votre personnage");
				StdDraw.picture(25.0, 50.0, "J1.JPG");
				StdDraw.text(25.0, 30, "Joueur 1");
				// StdDraw.picture(75.0, 10.0, "J1.JPG");
				StdDraw.pause(500);
			}

			while (choix4 != 1) {
				if (StdDraw.mousePressed()) {
					double x = StdDraw.mouseX();
					double y = StdDraw.mouseY();
					if (15 < x && x < 35) {
						choix5 = 2;
						StdDraw.text(60, 90, "Choix fait");
						StdDraw.pause(500);
					}

					else if (65 < y && y < 85) {
						choix5 = 2;
						StdDraw.text(60, 90, "Choix fait");
						StdDraw.pause(500);
					} else {

					}
				}
				break;
			}*/

			while (choix3 == 2) {
				if (StdDraw.mousePressed()) {
					int armee = 40;
					Partie p = new Partie(42, choix3); // création de la carte
					p.afficher_map(); // affichage de la carte
					// création joueurs
					Joueur j1 = new Joueur(1, StdDraw.BLUE, "bleu");
					Joueur j2 = new Joueur(2, StdDraw.GREEN, "vert");
					// liste aléatoire des territoires
					ArrayList l = new ArrayList<territoire>();
					l = p.randomAvecExclusion(1, 43);
					// découpage de la liste selon le nombre de joueurs
					List<territoire> l1 = l.subList(0, 21);
					List<territoire> l2 = l.subList(21, 42);
					// attribuer les territoires aux joueurs
					p.ajouter_teritoire(j1, l1);
					p.ajouter_teritoire(j2, l2);
					// affichage des territoires et armées des joueurs
					j1.territoire_joueur();
					// j1.armee_joueur(armee);
					j2.territoire_joueur();
					// j2.armee_joueur(armee);
					j1.affiche();
					j1.attribution_mission(rand.nextInt(8 - 1) + 1, choix3, j1);
					j2.affiche();
					j2.attribution_mission(rand.nextInt(8 - 1) + 1, choix3, j2);
					for (int i = 19; i > 0; i--) {
						System.out.println("joueur" + 1 + " place");
						System.out.println("Il vous reste " + i + " armées à placer");
						j1.choix_pays(1);
					}
					for (int i = 19; i > 0; i--) {
						System.out.println("joueur" + 2 + " place");
						System.out.println("Il vous reste " + i + " armées à placer");
						j2.choix_pays(1);
					}

					break;
				}
			}

// -------------------------------------------------------------------------------------------------------

			// 3 JOUEURS
			while (choix3 == 3) {
				if (StdDraw.mousePressed()) {
					int armee = 35;
					Partie p = new Partie(42, choix3); // création de la carte
					p.afficher_map(); // affichage de la carte
					// création joueurs
					Joueur j1 = new Joueur(1, StdDraw.BLUE, "bleu");
					Joueur j2 = new Joueur(2, StdDraw.GREEN, "vert");
					Joueur j3 = new Joueur(3, StdDraw.RED, "rouge");
					// liste aléatoire des territoires
					ArrayList l = new ArrayList<territoire>();
					l = p.randomAvecExclusion(1, 43);
					// découpage de la liste selon le nombre de joueurs
					List<territoire> l1 = l.subList(0, 14);
					List<territoire> l2 = l.subList(14, 28);
					List<territoire> l3 = l.subList(28, 42);
					// attribuer les territoires aux joueurs
					p.ajouter_teritoire(j1, l1);
					p.ajouter_teritoire(j2, l2);
					p.ajouter_teritoire(j3, l3);
					// affichage des territoires des joueurs
					j1.territoire_joueur();
					j1.armee_joueur(armee);
					j2.territoire_joueur();
					j2.armee_joueur(armee);
					j3.territoire_joueur();
					j3.armee_joueur(armee);
					j1.affiche();
					j2.affiche();
					j3.affiche();
					break;
				}

			}

			// 4 JOUEURS
			while (choix3 == 4) {
				if (StdDraw.mousePressed()) {
					int armee = 30;
					Partie p = new Partie(42, choix3); // création de la carte
					p.afficher_map(); // affichage de la carte
					// création joueurs
					Joueur j1 = new Joueur(1, StdDraw.BLUE, "bleu");
					Joueur j2 = new Joueur(2, StdDraw.GREEN, "vert");
					Joueur j3 = new Joueur(3, StdDraw.RED, "rouge");
					Joueur j4 = new Joueur(4, StdDraw.ORANGE, "orange");
					// liste aléatoire des territoires
					ArrayList l = new ArrayList<Integer>();
					l = p.randomAvecExclusion(1, 43);
					// découpage de la liste selon le nombre de joueurs
					List l1 = l.subList(0, 10);
					List l2 = l.subList(10, 21);
					List l3 = l.subList(21, 31);
					List l4 = l.subList(31, 42);
					// attribuer les territoires aux joueurs
					p.ajouter_teritoire(j1, l1);
					p.ajouter_teritoire(j2, l2);
					p.ajouter_teritoire(j3, l3);
					p.ajouter_teritoire(j4, l4);
					// affichage des territoires des joueurs
					j1.territoire_joueur();
					j1.armee_joueur(armee);
					j2.territoire_joueur();
					j2.armee_joueur(armee);
					j3.territoire_joueur();
					j3.armee_joueur(armee);
					j4.territoire_joueur();
					j4.armee_joueur(armee);
					j1.affiche();
					j2.affiche();
					j3.affiche();
					j4.affiche();
					break;
				}

			}
		}
	
}
