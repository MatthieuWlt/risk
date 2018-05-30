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
		View.afficherFond(60.0, 55.0, "Image/fond_intro.JPG");

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
				View.afficherFond(60.0, 55.0, "Image/back2.png");
				choix2 = 0;

				/* Affichage d'une image en fonction du nombre de joueurs */	
				while (choix2 != 1) {
					if (StdDraw.mousePressed()) {
						double x = StdDraw.mouseX();
						double y = StdDraw.mouseY();
						StdDraw.clear(StdDraw.WHITE);
						if (82 < y && y < 99) {
							View.afficherImage(60.0, 55.0, "Image/parchemin2.PNG");
							choix3 = 2;
							break;
						} else if (64 < y && y < 81) {
							View.afficherImage(60.0, 55.0, "Image/parchemin3.PNG");
							choix3 = 3;
							break;
						} else if (46 < y && y < 63) {
							View.afficherImage(60.0, 55.0, "Image/parchemin4.PNG");
							choix3 = 4;
							break;
						} else if (28 < y && y < 45) {
							View.afficherImage(60.0, 55.0, "Image/parchemin5.PNG");
							choix3 = 5;
							break;
						} else if (10 < y && y < 27) {
							View.afficherImage(60.0, 55.0, "Image/parchemin6.PNG");
							choix3 = 6;
							break;
						}
					} else {
					}
				}
			}


/* ----------------------------- Initialisation pour 2 JOUEURS ----------------------------- */

			/*while (choix3 == 2) {

				if (StdDraw.isMousePressed()) {
					// StdDraw.pause(500);
					// Affichage des deux personnages à choisir
					StdDraw.clear(StdDraw.WHITE);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(60, 90, "Joueur 1, choisissez votre personnage");
					StdDraw.picture(35.0, 55.0, "Image/Napo1.JPG");
					StdDraw.text(35.0, 20, "Napoléon");
					StdDraw.text(85.0, 20, "Jupiter");
					View.afficherImage(85.0, 55.0, "Image/Macron.png");
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
							View.afficherImage(60.0, 55.0, "Image/Macron.png");
							choix5 = 2;
							break;
						} else if (55 < x && x < 105) {
							choixJ2 = "Napoléon";
							choixJ1 = "Macron";
							StdDraw.clear(StdDraw.WHITE);
							StdDraw.setPenColor(StdDraw.BLACK);
							StdDraw.text(60, 90, "Joueur 2, choisissez votre personnage");
							StdDraw.text(60.0, 20, "Napoléon");
							View.afficherImage(60.0, 55.0, "Image/Napo1.JPG");
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
					Partie p = new Partie(42, choix3); // création de la carte
					View.afficher_map(); // affichage de la carte
					// création joueurs
					Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null);
					Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null);
					

					// attribution de la mission au joueur 1
					mission.affichage_mission(j1);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on ré-affiche la carte

					// attribution de la mission au joueur 2
					mission.affichage_mission(j2);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on ré-affiche la carte

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
					j2.territoire_joueur();

					j1.affiche();

					j2.affiche();

					View.placementArmeeRestantes(j1, choix41);
					View.placementArmeeRestantes(j2, choix41);

					for (int j = 0; j < 50; j++) { // boucle infinie
						System.out.println("joueur" + 1 + " place");
						int r1=j1.verif_region(j1);
						j1.initialisation(choix41,j1, 3+r1); // placement des armées du joueur 1
						System.out.println("le joueur1 attaque");
						j1.phase_attaque(1, j1, j2, null, null, null, null); // phase attaque du joueur 1
						System.out.println("le joueur1 déplace");
						j1.deplacement(1, j1); // phase déplacement du joueur 1
						j1.verification_mission(j1.getMission(), j1);
						
						int r2=j2.verif_region(j2);
						System.out.println("joueur" + 2 + " place");
						j2.initialisation(choix41,j2, 3+r2); // placement des armées du joueur 2
						System.out.println("le joueur2 attaque");
						j2.phase_attaque(1, j2, j1, null, null, null, null); // phase attaque du joueur 2
						System.out.println("le joueur2 déplace");
						j2.deplacement(1, j2); // phase déplacement du joueur 2
						j2.verification_mission(j2.getMission(), j2);
					}

					break;
				}
			}

/* ----------------------------- Initialisation pour 3 JOUEURS ----------------------------- */

			while (choix3 == 3) {
				if (StdDraw.mousePressed()) {
					int armee = 35;
					int choix41=1;
					
					Partie p = new Partie(42, choix3); // création de la carte
					View.afficher_map(); // affichage de la carte
					// création joueurs
					Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null);
					Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null);
					Joueur j3 = new Joueur(0, 3, StdDraw.RED, "rouge", null);
					
					// attribution de la mission au joueur 1
					mission.affichage_mission(j1);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on ré-affiche la carte

					// attribution de la mission au joueur 2
					mission.affichage_mission(j2);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on ré-affiche la carte
					
					// attribution de la mission au joueur 3
					mission.affichage_mission(j3);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on ré-affiche la carte
					
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
					j2.territoire_joueur();
					j3.territoire_joueur();
	
					j1.affiche();
					j2.affiche();
					j3.affiche();
					
					View.placementArmeeRestantes(j1,choix41);
					View.placementArmeeRestantes(j2,choix41);
					View.placementArmeeRestantes(j3,choix41);

					while(choix41==1) { // bouocle infinie
						System.out.println("joueur" + 1 + " place");
						int r1=j1.verif_region(j1);
						j1.initialisation(choix41,j1, 3+r1); // placement des armées du joueur 1
						System.out.println("le joueur1 attaque");
						j1.phase_attaque(1, j1, j2,j3, null, null, null); // phase attaque du joueur 1
						System.out.println("le joueur1 déplace");
						j1.deplacement(1, j1); // phase déplacement du joueur 1
						j1.verification_mission(j1.getMission(), j1);
						
						int r2=j2.verif_region(j2);
						System.out.println("joueur" + 2 + " place");
						j2.initialisation(choix41,j2, 3+r2); // placement des armées du joueur 2
						System.out.println("le joueur2 attaque");
						j2.phase_attaque(1, j2, j1, j3, null, null, null); // phase attaque du joueur 2
						System.out.println("le joueur2 déplace");
						j2.deplacement(1, j2); // phase déplacement du joueur 2
						j2.verification_mission(j2.getMission(), j2);
						
						int r3=j3.verif_region(j3);
						System.out.println("joueur" + 3 + " place");
						j3.initialisation(choix41,j3, 3+r3); // placement des armées du joueur 3
						System.out.println("le joueur3 attaque");
						j3.phase_attaque(1, j3, j1, j2, null, null, null); // phase attaque du joueur 3
						System.out.println("le joueur3 déplace");
						j3.deplacement(1, j3); // phase déplacement du joueur 3
						j3.verification_mission(j3.getMission(), j3);
					}
					break;
				}

			}

/* ----------------------------- Initialisation pour 4 JOUEURS ----------------------------- */
			
			while (choix3 == 4) {
				if (StdDraw.mousePressed()) {
					int choix41=1;
					if (StdDraw.mousePressed()) {
						int armee = 30;
						Partie p = new Partie(42, choix3); // création de la carte
						View.afficher_map(); // affichage de la carte
						// création joueurs
						Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null);
						Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null);
						Joueur j3 = new Joueur(0, 3, StdDraw.RED, "rouge", null);
						Joueur j4 = new Joueur(0, 4, StdDraw.ORANGE, "orange", null);
						
						// attribution de la mission au joueur 1
						mission.affichage_mission(j1);
						StdDraw.clear();// on supprime le message de mission
						View.afficher_map(); // on ré-affiche la carte
						
						// attribution de la mission au joueur 2
						mission.affichage_mission(j2);
						StdDraw.clear();// on supprime le message de mission
						View.afficher_map(); // on ré-affiche la carte
						
						// attribution de la mission au joueur 3
						mission.affichage_mission(j3);
						StdDraw.clear();// on supprime le message de mission
						View.afficher_map(); // on ré-affiche la carte
						
						// attribution de la mission au joueur 4
						mission.affichage_mission(j4);
						StdDraw.clear();// on supprime le message de mission
						View.afficher_map(); // on ré-affiche la carte
						
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
						j2.territoire_joueur();
						j3.territoire_joueur();
						j4.territoire_joueur();

						j1.affiche();
						j2.affiche();
						j3.affiche();
						j4.affiche();
						
						View.placementArmeeRestantes(j1,choix41);
						View.placementArmeeRestantes(j2,choix41);
						View.placementArmeeRestantes(j3,choix41);
						View.placementArmeeRestantes(j4,choix41);
						
						while(choix41==1) { //boucle infinie
							System.out.println("joueur" + 1 + " place");
							int r1=j1.verif_region(j1);
							j1.initialisation(choix41,j1, 3+r1); // placement des armées du joueur 1
							System.out.println("le joueur1 attaque");
							j1.phase_attaque(1, j1, j2,j3, null, null, null); // phase attaque du joueur 1
							System.out.println("le joueur1 déplace");
							j1.deplacement(1, j1); // phase déplacement du joueur 1
							j1.verification_mission(j1.getMission(), j1);
							
							int r2=j2.verif_region(j2);
							System.out.println("joueur" + 2 + " place");
							j2.initialisation(choix41,j2, 3+r2); // placement des armées du joueur 2
							System.out.println("le joueur2 attaque");
							j2.phase_attaque(1, j2, j1, j3, null, null, null); // phase attaque du joueur 2
							System.out.println("le joueur2 déplace");
							j2.deplacement(1, j2); // phase déplacement du joueur 2
							j2.verification_mission(j2.getMission(), j2);
							
							int r3=j3.verif_region(j3);
							System.out.println("joueur" + 3 + " place");
							j3.initialisation(choix41,j3, 3+r3); // placement des armées du joueur 3
							System.out.println("le joueur3 attaque");
							j3.phase_attaque(1, j3, j1, j2, null, null, null); // phase attaque du joueur 3
							System.out.println("le joueur3 déplace");
							j3.deplacement(1, j3); // phase déplacement du joueur 3
							j3.verification_mission(j3.getMission(), j3);
							
							int r4=j4.verif_region(j4);
							System.out.println("joueur" + 4 + " place");
							j4.initialisation(choix41,j4, 3+r4); // placement des armées du joueur 4
							System.out.println("le joueur4 attaque");
							j4.phase_attaque(1, j4, j1, j2, j3, null, null); // phase attaque du joueur 4
							System.out.println("le joueur4 déplace");
							j4.deplacement(1, j4); // phase déplacement du joueur 4
							j4.verification_mission(j4.getMission(), j4);
						}
						break;
				}
			}
		}
	}
	}		
}
