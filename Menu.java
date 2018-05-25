import edu.princeton.cs.introcs.StdDraw;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class Menu {

	public static void main(String[] args) throws InterruptedException {
		
		/* Initialisation de la taille de la fenêtre et affichage du fond d'into */
		StdDraw.setCanvasSize(1229, 576);
		StdDraw.setXscale(0.0, 120);
		StdDraw.setYscale(0.0, 110);
		afficherFond(60.0, 55.0, "Image/fond_intro.JPG");

		// Définition d'une police et de sa taille
		Font currentFont = StdDraw.getFont();
		float size = 25;
		currentFont = currentFont.deriveFont(size);
		StdDraw.setFont(currentFont);

		/* Initialisation des choix */
		int choix1 = 0; // Pour atteindre le menu
		int choix2 = 1;
		int choix3 = 0; // Pour le choix du nombre de joueurs et l'affichage de la carte
		int choix4 = 1;
		int choix5 = 0; // Choix du personnage
		String choixJ1 = "";
		String choixJ2 = "";
		Random rand = new Random();

		
		while (choix1 != 1) {
			if (StdDraw.isMousePressed()) {
				afficherFond(60.0, 55.0, "Image/back2.png");
				choix2 = 0;

				/* Affichage d'une image en fonction du nombre de joueurs */	
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
				}
			}


/* ----------------------------- Initialisation pour 2 JOUEURS ----------------------------- */

			/*
			while (choix3 == 2) {

				if (StdDraw.isMousePressed()) {
					// StdDraw.pause(500);
					// Affichage des deux personnages à choisir
					StdDraw.clear(StdDraw.WHITE);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(60, 90, "Joueur 1, choisissez votre personnage");
					StdDraw.picture(35.0, 55.0, "Image/Napo1.JPG");
					StdDraw.text(35.0, 20, "Napoléon");
					StdDraw.text(85.0, 20, "Jupiter");
					afficherImage(85.0, 55.0, "Image/Macron.png");
					choix4 = 0;

				}
				while (choix4 != 1) {
					if (StdDraw.mousePressed()) {
						// Affichage du personnage restant en fonction du choix précédent
						double x = StdDraw.mouseX();
						double y = StdDraw.mouseY();
						if (15 < x && x < 55) {

							choixJ1 = "Napoléon";
							choixJ2 = "Macron";
							StdDraw.clear(StdDraw.WHITE);
							StdDraw.setPenColor(StdDraw.BLACK);
							StdDraw.text(60, 90, "Joueur 2, choisissez votre personnage");
							StdDraw.text(60.0, 20, "Jupiter");
							afficherImage(60.0, 55.0, "Image/Macron.png");
							choix5 = 2;
							break;
						} else if (55 < x && x < 105) {
							choixJ2 = "Napoléon";
							choixJ1 = "Macron";
							StdDraw.clear(StdDraw.WHITE);
							StdDraw.setPenColor(StdDraw.BLACK);
							StdDraw.text(60, 90, "Joueur 2, choisissez votre personnage");
							StdDraw.text(60.0, 20, "Napoléon");
							afficherImage(60.0, 55.0, "Image/Napo1.JPG");
							choix5 = 2;
							System.out.println(choix5);
							break;
						} else {
						}
						// break;
					} else {

					}
				}
				break;
			}*/

			while (choix3 == 2) {
				if (StdDraw.mousePressed()) {
					int armee = 40;
					int choix41 = 1;
					
					// Création et affichage de la carte
					Partie p = new Partie(42, choix3); 
					p.afficher_map(); 
					
					// Création des joueurs
					Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null);
					Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null);

					// Attribution de la mission au joueur 1
					int choixmissionj1 = 0;
					while (choixmissionj1 == 0) {
						if (StdDraw.isMousePressed()) {
							
							// On récupère les coordonnées x et y du clic
							double x4 = StdDraw.mouseX();
							double y4 = StdDraw.mouseY();
							
							// Si le clic est sur le bouton
							if (x4 < 116 && x4 > 104 && y4 < 104 && y4 > 96) { 
								int missionj1 = rand.nextInt(2 - 1) + 1; // On choisit une mission aléatoire
								j1.attribution_mission(missionj1, 2, j1); // On attribut une mission au joueur 1
								j1.setMission(missionj1); // On attribut la mission 1 au joueur 1
								choixmissionj1 = 1; // On termine la boucle while
							} else {
								choixmissionj1 = 0; // On redemande au joueur de choisir sa mission
								StdDraw.text(60, 105, " Joueur 1, découvrez votre mission");
							}
						} else {
							choixmissionj1 = 0;// On demande au joueur de choisir sa mission
							StdDraw.text(60, 105, "Joueur 1, découvrez votre mission");
						}
					}

					// On supprime le message de mission et on ré-affiche la carte
					StdDraw.clear();
					p.afficher_map(); 

					/* Attribution de la mission au joueur 2 */
					int choixmissionj2 = 0;

					while (choixmissionj2 == 0) {
						if (StdDraw.isMousePressed()) {
							
							double x5 = StdDraw.mouseX();
							double y5 = StdDraw.mouseY();
							
							if (x5 < 116 && x5 > 104 && y5 < 104 && y5 > 96) {
								int missionj2 = rand.nextInt(8 - 1) + 1;
								j2.setMission(missionj2);
								j2.attribution_mission(missionj2, 2, j2);
								choixmissionj2 = 1;
							} else {
								choixmissionj2 = 0;
								StdDraw.text(60, 105, " Joueur 2, découvrez votre mission");
							}
						} else {
							choixmissionj2 = 0;
							StdDraw.text(60, 105, "Joueur 2, découvrez votre mission");
						}
					}

					// On supprime le message de mission et on ré-affiche la carte
					StdDraw.clear();
					p.afficher_map(); 

					// On vérifie qu'aucun joueur n'a gagné
					j1.verification_mission(j1.getMission(), j1);
					j2.verification_mission(j2.getMission(), j2);

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
					j2.territoire_joueur();;
					
					j1.affiche();
					j2.affiche();
					
					placementArmeeRestantes(j1, j2, choix41);

					for (int j = 0; j < 10; j++) { // nombre de tour arbitraire
						
						// Affichage des textes pour un joueur
						System.out.println("Joueur" + 1 + " place");
						j1.initialisation(choix41, j1, 3); // Placement des armées du joueur 1
						System.out.println("Le joueur1 attaque");
						j1.phase_attaque(1, j1, j2); // Phase attaque du joueur 1
						System.out.println("Le joueur1 déplace");
						j1.deplacement(1, j1); //Phase attaque du joueur 1

						System.out.println("Joueur" + 2 + " place");
						j2.initialisation(choix41, j2, 3);
						System.out.println("Le joueur2 attaque");
						j2.phase_attaque(1, j2, j1); 
						System.out.println("Le joueur2 déplace");
						j1.deplacement(1, j2); 
					}
					break;
				}
			}

/* ----------------------------- Initialisation pour 3 JOUEURS ----------------------------- */

			while (choix3 == 3) {
				if (StdDraw.mousePressed()) {
					int armee = 35;

					Partie p = new Partie(42, choix3); 
					p.afficher_map(); 

					Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null);
					Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null);
					Joueur j3 = new Joueur(0, 3, StdDraw.RED, "rouge", null);

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
					break;
				}

			}

/* ----------------------------- Initialisation pour 4 JOUEURS ----------------------------- */
			
			while (choix3 == 4) {
				if (StdDraw.mousePressed()) {
					int armee = 30;
					
					Partie p = new Partie(42, choix3); 
					p.afficher_map(); 
					
					Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null);
					Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null);
					Joueur j3 = new Joueur(0, 3, StdDraw.RED, "rouge", null);
					Joueur j4 = new Joueur(0, 4, StdDraw.ORANGE, "orange", null);
					
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
		public static void placementArmeeRestantes(Joueur j1, Joueur j2, int choix4) {
			System.out.println("Joueur " + 1 + " place");
			j1.initialisation(choix4, j1, 5); // placement des armées du joueur 1
			System.out.println("joueur " + 2 + " place");
			j2.initialisation(choix4, j2, 5); // placement des armées du joueur 2
		}
		
}
