import edu.princeton.cs.introcs.StdDraw;
import java.io.*;

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

		afficherFond(60.0, 55.0, "Image/fond_intro.JPG");

		//Définition d'une police et de sa taille
		Font currentFont = StdDraw.getFont();
		float size = 25;
		currentFont = currentFont.deriveFont(size);
		StdDraw.setFont(currentFont);

		/* INITIALISATION DES CHOIX */
		
		int choix1 = 0; // Pour atteindre le menu
		int choix2 = 0; 
		int choix3 = 0; // Pour le choix du nombre de joueurs et l'affichage de la carte
		int choix4 = 0; 
		int choix5 = 0; // Choix du personnage
		String choixJ1 = "";
		String choixJ2 = "";
		Random rand = new Random();

		while (choix1 != 1) {
			if (StdDraw.isMousePressed()) { // si l'utilisateur clique, alors on affiche
				afficherFond(60.0, 55.0, "Image/back2.png");
			}
			

			while (choix2 != 1) {
				if (StdDraw.mousePressed()) {
					double x = StdDraw.mouseX();
					double y = StdDraw.mouseY();
					StdDraw.clear(StdDraw.WHITE);
					if (82 < y && y < 99) {
						afficherImage(60.0, 55.0, "Image/parchemin2.PNG");
						choix3 = 2;
						break;
					} else if (64 < y && y < 81) {
						afficherImage(60.0, 55.0, "Image/parchemin3.PNG");
						choix3 = 3;
						break;
					} else if (46 < y && y < 63) {
						afficherImage(60.0, 55.0, "Image/parchemin4.PNG");
						choix3 = 4;
						break;
					} else if (28 < y && y < 45) {
						afficherImage(60.0, 55.0, "Image/parchemin5.PNG");
						choix3 = 5;
						break;
					} else if (10 < y && y < 27) {
						afficherImage(60.0, 55.0, "Image/parchemin6.PNG");
						choix3 = 6;
						break;
					}
				} else {
				}
				break;
			} /* l'utilisateur ne clique pas, le menu ne s'affiche pas CHOIX 1 */

			
/* ----------------------------- Initialisation pour 2 JOUEURS ----------------------------- */

			/*
			while (choix3 == 2) {
				if (StdDraw.isMousePressed()) {
					// Affichage des deux personnages à choisir
					StdDraw.clear(StdDraw.WHITE);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(60, 90, "Joueur 1, choisissez votre personnage");
					StdDraw.picture(35.0, 55.0, "Image/Napo1.JPG");
					StdDraw.text(35.0, 20, "Napoléon");
					StdDraw.text(85.0, 20, "Jupiter");
					afficherImage(85.0, 55.0, "Image/Macron.png");
					
				}

				while (choix4 != 1) {
					if (StdDraw.mousePressed()) {
						// Affichage du personnage restant en fonction du choix précédent
						double x = StdDraw.mouseX();
						double y = StdDraw.mouseY();
						if (15 < x && x < 55) {
							choix5 = 2;
							choixJ1 = "Napoléon";
							choixJ2 = "Macron";
							StdDraw.pause(500);
							StdDraw.clear(StdDraw.WHITE);
							StdDraw.setPenColor(StdDraw.BLACK);
							StdDraw.text(60, 90, "Joueur 2, choisissez votre personnage");
							StdDraw.text(60.0, 20, "Jupiter");
							afficherImage(60.0, 55.0, "Image/Macron.png");
							break;
						}

						else if (55 < x && x < 105) {
							choix5 = 2;
							choixJ2 = "Napoléon";
							choixJ1 = "Macron";
							StdDraw.pause(500);
							StdDraw.clear(StdDraw.WHITE); 
							StdDraw.setPenColor(StdDraw.BLACK);
							StdDraw.text(60, 90, "Joueur 2, choisissez votre personnage");
							StdDraw.text(60.0, 20, "Napoléon");
							afficherImage(60.0, 55.0, "Image/Napo1.JPG");
							break;
						} else {
						}
					}
					break;
				}	*/
			
			while (choix3 == 2) {
					if (StdDraw.mousePressed()) {
						int armee = 40;
						
						// Création et affichage de la carte
						Partie p = new Partie(42, choix3); 
						p.afficher_map(); 
						
						// Création des joueurs
						Joueur j1 = new Joueur(choixJ1, 1, StdDraw.BLUE, "bleu");
						Joueur j2 = new Joueur(choixJ2, 2, StdDraw.GREEN, "vert");
						
						// Liste aléatoire des territoires
						ArrayList l = new ArrayList<territoire>();
						l = p.randomAvecExclusion(1, 43);
						
						// Découpage de la liste selon le nombre de joueurs
						List<territoire> l1 = l.subList(0, 21);
						List<territoire> l2 = l.subList(21, 42);
						
						// Attribution des territoires aux joueurs
						p.ajouter_teritoire(j1, l1);
						p.ajouter_teritoire(j2, l2);
						
						// Affichage des territoires et armées des joueurs
						j1.territoire_joueur();
						j1.affiche();
						j1.attribution_mission(rand.nextInt(8 - 1) + 1, choix3, j1);
						
						j2.territoire_joueur();;
						j2.affiche();
						j2.attribution_mission(rand.nextInt(8 - 1) + 1, choix3, j2);
						
						placementArmeeRestantes(j1, 1);
						placementArmeeRestantes(j2, 2);
					
						break;
					}
				}

/* ----------------------------- Initialisation pour 3 JOUEURS ----------------------------- */
				
				while (choix3 == 3) {
					if (StdDraw.mousePressed()) {
						int armee = 35;

						Partie p = new Partie(42, choix3); 
						p.afficher_map(); 

						Joueur j1 = new Joueur(null, 1, StdDraw.BLUE, "bleu");
						Joueur j2 = new Joueur(null, 2, StdDraw.GREEN, "vert");
						Joueur j3 = new Joueur(null, 3, StdDraw.RED, "rouge");

						ArrayList l = new ArrayList<territoire>();
						l = p.randomAvecExclusion(1, 43);
						
						List<territoire> l1 = l.subList(0, 14);
						List<territoire> l2 = l.subList(14, 28);
						List<territoire> l3 = l.subList(28, 42);
						
						p.ajouter_teritoire(j1, l1);
						p.ajouter_teritoire(j2, l2);
						p.ajouter_teritoire(j3, l3);
						
						
						j1.territoire_joueur();
						j1.armee_joueur(armee);
						j1.affiche();
						
						j2.territoire_joueur();
						j2.armee_joueur(armee);
						j2.affiche();
						
						j3.territoire_joueur();
						j3.armee_joueur(armee);
						j3.affiche();
						
						placementArmeeRestantes(j1, 1);
						placementArmeeRestantes(j2, 2);
						placementArmeeRestantes(j3, 3);
						
						break;
					}

				}

/* ----------------------------- Initialisation pour 4 JOUEURS ----------------------------- */
				
				while (choix3 == 4) {
					if (StdDraw.mousePressed()) {
						int armee = 30;
						
						Partie p = new Partie(42, choix3); 
						p.afficher_map(); 
						
						Joueur j1 = new Joueur(null, 1, StdDraw.BLUE, "bleu");
						Joueur j2 = new Joueur(null, 2, StdDraw.GREEN, "vert");
						Joueur j3 = new Joueur(null, 3, StdDraw.RED, "rouge");
						Joueur j4 = new Joueur(null, 4, StdDraw.ORANGE, "orange");
						
						ArrayList l = new ArrayList<Integer>();
						l = p.randomAvecExclusion(1, 43);

						List l1 = l.subList(0, 10);
						List l2 = l.subList(10, 21);
						List l3 = l.subList(21, 31);
						List l4 = l.subList(31, 42);

						p.ajouter_teritoire(j1, l1);
						p.ajouter_teritoire(j2, l2);
						p.ajouter_teritoire(j3, l3);
						p.ajouter_teritoire(j4, l4);

						j1.territoire_joueur();
						j1.armee_joueur(armee);
						j1.affiche();
						
						j2.territoire_joueur();
						j2.armee_joueur(armee);
						j2.affiche();
						
						j3.territoire_joueur();
						j3.armee_joueur(armee);
						j3.affiche();
						
						j4.territoire_joueur();
						j4.armee_joueur(armee);
						j4.affiche();
						
						placementArmeeRestantes(j1, 1);
						placementArmeeRestantes(j2, 2);
						placementArmeeRestantes(j3, 3);
						placementArmeeRestantes(j4, 4);
						break;
					}

				}
			}
		}
	

	// Fonction permettant d'afficher une image en fond
	public static void afficherFond(double x, double y, String fichier) {
			StdDraw.clear(StdDraw.WHITE);
			StdDraw.picture(x, y, fichier);
			StdDraw.pause(500);
	}
	
	// Fonction permettant d'afficher une image
	public static void afficherImage(double x, double y, String fichier) {
		StdDraw.picture(x, y, fichier);
		StdDraw.pause(500);
	}
	
	// Fonction permettant d'afficher le nombre d'armées qu'il reste à placer en console
	public static void placementArmeeRestantes(Joueur j, int n) {
		for (int i = 19; i > 0; i--) {
			System.out.println("Joueur " + n + " place");
			System.out.println("Il vous reste " + i + " armées à placer");
			j.choix_pays(1);
		}
	}
	
}
