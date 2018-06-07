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

		// D�finition d'une police et de sa taille
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
		int choix9 = 0;
		int choix10 = 0;
		String persoj1="";
		String persoj2="";
		String persoj3="";
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
						if (67 < y && y < 81 && 8 < x && x < 52) {
							View.afficherImage(60.0, 55.0, "Image/parchemin2.PNG");
							StdDraw.pause(500);
							choix3 = 2;
							break;
						} else if (48 < y && y < 61 && 8 < x && x < 52) {
							View.afficherImage(60.0, 55.0, "Image/parchemin3.PNG");
							StdDraw.pause(500);
							choix3 = 3;
							break;
						} else if (29 < y && y < 43 && 8 < x && x < 52) {
							View.afficherImage(60.0, 55.0, "Image/parchemin4.PNG");
							StdDraw.pause(500);
							choix3 = 4;
							break;
						} else if (12 < y && y < 26 && 8 < x && x < 52) {
							View.afficherImage(60.0, 55.0, "Image/parchemin5.PNG");
							StdDraw.pause(500);
							choix3 = 5;
							break;
						} 		
						else if (67 < y && y < 81 && 64 < x && x < 110) {
							View.afficherImage(60.0, 55.0, "Image/parchemin2.PNG");
							StdDraw.pause(500);
							choix3 = 11;
							break;
						}
						else if (48 < y && y < 61 && 64 < x && x < 110) {
							View.afficherImage(60.0, 55.0, "Image/parchemin3.PNG");
							StdDraw.pause(500);
							choix3 = 12;
							break;
						}
						else if (29 < y && y < 43 && 64 < x && x < 110) {
							View.afficherImage(60.0, 55.0, "Image/parchemin3.PNG");
							StdDraw.pause(500);
							choix3 = 21;
							break;
						}
						else if (12 < y && y < 26 && 64 < x && x < 110) {
							View.afficherImage(60.0, 55.0, "Image/parchemin6.PNG");
							StdDraw.pause(500);
							choix3 = 6;
							break;
						}
						else {
							View.afficherFond(60.0, 55.0, "Image/back2.png");
							choix2 = 0;
						}
					} else {
					}
				}
			}
			


/* ----------------------------- Initialisation pour 2 JOUEURS ----------------------------- */

			while (choix3 == 2) {
				if (StdDraw.isMousePressed()) {
					// Affichage des deux personnages � choisir
					View.affichage_personnage(2, "Image/Napopo.png", "Image/wellington.png", null);
					View.afficherImage(60,55,"Image/versus.png");
					StdDraw.text(60, 100, "Joueur 1, choisissez votre personnage");
					choix3=0;
					choix4 = 0;
				}
				
				while (choix4 != 1) {
					if (StdDraw.mousePressed()) {
						// Affichage du personnage restant en fonction du choix pr�c�dent
						double x = StdDraw.mouseX();
						double y = StdDraw.mouseY();
						if (15 < x && x < 55) {
							View.affichage_personnage(1, "Image/wellington.png", null, null);
							StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
							persoj1="Image/Napopo_petit.png";
							persoj2="Image/wellington_petit.png";
							choix5 = 2;
							break;
						} else if (55 < x && x < 105) {
							View.affichage_personnage(1, "Image/Napopo.png", null, null);
							StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
							choix5 = 2;
							persoj1="Image/wellington_petit.png";
							persoj2="Image/Napopo_petit.png";
							break;
						} else {
							View.affichage_personnage(2, "Image/Napopo.png", "Image/wellington.png", null);
							StdDraw.text(60, 100, "Joueur 1, choisissez votre personnage");
							View.afficherImage(60,55,"Image/versus.png");
							choix4 = 0;
						}
					} else {
					}
				}
			}
			
			// Lancement de la partie
						while (choix5 == 2) {
							if (StdDraw.mousePressed()) {
								int armee = 40;
								int choix41 = 1;
								
								// Cr�ation et affichage de la carte
								Partie p = new Partie(42, choix5);
								View.afficher_map();
								
								// Cr�ation des joueurs
								Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null, persoj1);
								Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null, persoj2);

								// Attribution de la mission au joueur 1
								mission.Chat_Box_Mission(j1,p);
								StdDraw.clear();
								View.afficher_map(); // on r�-affiche la carte

								// Attribution de la mission au joueur 2
								mission.Chat_Box_Mission(j2,p);
								StdDraw.clear();
								View.afficher_map(); // on r�-affiche la carte

								// Cr�ation de la liste des territoires
								ArrayList l = new ArrayList<territoire>();
								l = p.randomAvecExclusion(1, 43);
								
								// D�coupage de la liste selon le nombre de joueurs
								List<territoire> l1 = l.subList(0, 21);
								List<territoire> l2 = l.subList(21, 42);
								
								// Attribution des territoires aux joueurs
								p.ajouter_teritoire(j1, l1);
								p.ajouter_teritoire(j2, l2);
								
								// Affichage des territoires et arm�es des joueurs
								j1.territoire_joueur();
								j2.territoire_joueur();
								
								p.placementArmeeRestantes(j1, choix41, 19);
								p.placementArmeeRestantes(j2, choix41,19);
								
								while(choix41==1) { // boucle infinie
									System.out.println("joueur" + 1 + " place");
									int r1=j1.verif_region(j1);
									j1.initialisation(choix41,j1, 3+r1); // placement des arm�es du joueur 1
									System.out.println("le joueur1 attaque");
									j1.phase_attaque(1, j1, j2, null, null, null, null); // phase attaque du joueur 1
									System.out.println("le joueur1 d�place");
									j1.deplacement(1, j1); // phase d�placement du joueur 1
									j1.verification_mission(j1.getMission(), j1);
									
									int r2=j2.verif_region(j2);
									System.out.println("joueur" + 2 + " place");
									j2.initialisation(choix41,j2, 3+r2); // placement des arm�es du joueur 2
									System.out.println("le joueur2 attaque");
									j2.phase_attaque(1, j2, j1, null, null, null, null); // phase attaque du joueur 2
									System.out.println("le joueur2 d�place");
									j2.deplacement(1, j2); // phase d�placement du joueur 2
									j2.verification_mission(j2.getMission(), j2);
								}

								break;
							}
						}

/* ------------------------------------- Initialisation pour 3 JOUEURS ------------------------------------- */

			while (choix3 == 3) {
				if (StdDraw.isMousePressed()) {
					// Affichage des deux personnages � choisir
					View.affichage_personnage(3, "Image/Napopo.png", "Image/cesar.png", "Image/wellington.png");
					View.afficherImage(39,55,"Image/versus.png");
					View.afficherImage(82,55,"Image/versus.png");
					StdDraw.text(60, 100, "Joueur 1, choisissez votre personnage");
					choix3=0;
					choix4 = 0;
				}
				
				while (choix4 != 1) {
					if (StdDraw.mousePressed()) {
						// Affichage du personnage restant en fonction du choix pr�c�dent
						double x = StdDraw.mouseX();
						double y = StdDraw.mouseY();
						if (5 < x && x < 35) {
							persoj1="Image/Napopo_petit.png";
							View.affichage_personnage(2, "Image/cesar.png", "Image/wellington.png", null);
							View.afficherImage(60,55,"Image/versus.png");
							StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
							while (choix10 != 1) {
								if (StdDraw.mousePressed()) {
								double x1 = StdDraw.mouseX();
								double y1 = StdDraw.mouseY();
								if (15 < x1 && x1 < 55) {
									View.affichage_personnage(1, "Image/wellington.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 3;
									persoj3="Image/wellington_petit.png";
									persoj2="Image/cesar_petit.png";
									break;
								} else if (55 < x1 && x1 < 105) {
									View.affichage_personnage(1, "Image/cesar.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 3;
									persoj2="Image/wellington_petit.png";
									persoj3="Image/cesar_petit.png";
									break;
								} else {
									View.affichage_personnage(2, "Image/cesar.png", "Image/wellington.png", null);
									View.afficherImage(60,55,"Image/versus.png");
									StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
									choix4 = 0;
								}
								}
							}
							break;
						} 
						
						else if (45 < x && x < 75) {
							persoj1="Image/cesar_petit.png";
							View.affichage_personnage(2, "Image/Napopo.png", "Image/wellington.png", null);
							View.afficherImage(60,55,"Image/versus.png");
							StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
							while (choix10 != 1) {
								if (StdDraw.mousePressed()) {
								double x1 = StdDraw.mouseX();
								double y1 = StdDraw.mouseY();
								if (15 < x1 && x1 < 55) {
									View.affichage_personnage(1, "Image/wellington.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 3;
									persoj3="Image/wellington_petit.png";
									persoj2="Image/Napopo_petit.png";
									break;
								} else if (55 < x1 && x1 < 105) {
									View.affichage_personnage(1, "Image/Napopo.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 3;
									persoj2="Image/wellington_petit.png";
									persoj3="Image/Napopo_petit.png";
									break;
								} else {
									View.affichage_personnage(2, "Image/Napopo.png", "Image/wellington.png", null);
									View.afficherImage(60,55,"Image/versus.png");
									StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
									choix4 = 0;
								}
								}
							}
							break;
						} 
						
						
						else if (85 < x && x < 115) {
							persoj1="Image/wellington_petit.png";
							View.affichage_personnage(2, "Image/Napopo.png", "Image/cesar.png", null);
							View.afficherImage(60,55,"Image/versus.png");
							StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
							while (choix10 != 1) {
								if (StdDraw.mousePressed()) {
								double x1 = StdDraw.mouseX();
								double y1 = StdDraw.mouseY();
								if (15 < x1 && x1 < 55) {
									View.affichage_personnage(1, "Image/cesar.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 2;
									persoj2="Image/Napopo_petit.png";
									persoj3="Image/cesar_petit.png";
									break;
								} else if (55 < x1 && x1 < 105) {
									View.affichage_personnage(1, "Image/Napopo.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 2;
									persoj3="Image/Napopo_petit.png";
									persoj2="Image/cesar_petit.png";
									break;
								} else {
									View.affichage_personnage(2, "Image/Napopo.png", "Image/cesar.png", null);
									StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
									choix4 = 0;
								}
								}
							}
							break;
						}
						else {
							// Affichage des deux personnages � choisir
							View.affichage_personnage(3, "Image/Napopo.png", "Image/cesar.png", "Image/wellington.png");
							View.afficherImage(39,55,"Image/versus.png");
							View.afficherImage(82,55,"Image/versus.png");
							StdDraw.text(60, 100, "Joueur 1, choisissez votre personnage");
							choix4 = 0;
						}
					} else {
					}
				}
			}
			
			
			while (choix5 == 3) {
				if (StdDraw.mousePressed()) {
					int armee = 35;
					int choix41=1;
					
					Partie p = new Partie(42, choix3); // cr�ation de la carte
					View.afficher_map(); // affichage de la carte
					// cr�ation joueurs
					Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null, persoj1);
					Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null, persoj2);
					Joueur j3 = new Joueur(0, 3, StdDraw.RED, "rouge", null, persoj3);
					
					// attribution de la mission au joueur 1
					mission.Chat_Box_Mission(j1,p);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on r�-affiche la carte

					// attribution de la mission au joueur 2
					mission.Chat_Box_Mission(j2,p);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on r�-affiche la carte
					
					// attribution de la mission au joueur 3
					mission.Chat_Box_Mission(j3,p);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on r�-affiche la carte
					
					// liste al�atoire des territoires
					ArrayList l = new ArrayList<territoire>();
					l = p.randomAvecExclusion(1, 43);
					
					// d�coupage de la liste selon le nombre de joueurs
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
					
					p.placementArmeeRestantes(j1,choix41,21);
					p.placementArmeeRestantes(j2,choix41,21);
					p.placementArmeeRestantes(j3,choix41,21);

					while(choix41==1) { // boucle infinie
						System.out.println("joueur" + 1 + " place");
						int r1=j1.verif_region(j1);
						j1.initialisation(choix41,j1, 3+r1); // placement des arm�es du joueur 1
						System.out.println("le joueur1 attaque");
						j1.phase_attaque(1, j1, j2,j3, null, null, null); // phase attaque du joueur 1
						System.out.println("le joueur1 d�place");
						j1.deplacement(1, j1); // phase d�placement du joueur 1
						j1.verification_mission(j1.getMission(), j1);
						
						int r2=j2.verif_region(j2);
						System.out.println("joueur" + 2 + " place");
						j2.initialisation(choix41,j2, 3+r2); // placement des arm�es du joueur 2
						System.out.println("le joueur2 attaque");
						j2.phase_attaque(1, j2, j1, j3, null, null, null); // phase attaque du joueur 2
						System.out.println("le joueur2 d�place");
						j2.deplacement(1, j2); // phase d�placement du joueur 2
						j2.verification_mission(j2.getMission(), j2);
						
						int r3=j3.verif_region(j3);
						System.out.println("joueur" + 3 + " place");
						j3.initialisation(choix41,j3, 3+r3); // placement des arm�es du joueur 3
						System.out.println("le joueur3 attaque");
						j3.phase_attaque(1, j3, j1, j2, null, null, null); // phase attaque du joueur 3
						System.out.println("le joueur3 d�place");
						j3.deplacement(1, j3); // phase d�placement du joueur 3
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
						Partie p = new Partie(42, choix3); // cr�ation de la carte
						View.afficher_map(); // affichage de la carte
						// cr�ation joueurs
						Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null, "Image/J1.png");
						Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null, "Image/J2.png");
						Joueur j3 = new Joueur(0, 3, StdDraw.RED, "rouge", null, "Image/J3.png");
						Joueur j4 = new Joueur(0, 4, StdDraw.ORANGE, "orange", null, "Image/J4.png");
						
						// attribution de la mission au joueur 1
						mission.Chat_Box_Mission(j1,p);
						StdDraw.clear();// on supprime le message de mission
						View.afficher_map(); // on r�-affiche la carte
						
						// attribution de la mission au joueur 2
						mission.Chat_Box_Mission(j2,p);
						StdDraw.clear();// on supprime le message de mission
						View.afficher_map(); // on r�-affiche la carte
						
						// attribution de la mission au joueur 3
						mission.Chat_Box_Mission(j3,p);
						StdDraw.clear();// on supprime le message de mission
						View.afficher_map(); // on r�-affiche la carte
						
						// attribution de la mission au joueur 4
						mission.Chat_Box_Mission(j4,p);
						StdDraw.clear();// on supprime le message de mission
						View.afficher_map(); // on r�-affiche la carte
						
						// liste al�atoire des territoires
						ArrayList l = new ArrayList<Integer>();
						l = p.randomAvecExclusion(1, 43);
						// d�coupage de la liste selon le nombre de joueurs
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

						p.placementArmeeRestantes(j1,choix41,20);
						p.placementArmeeRestantes(j2,choix41,19);
						p.placementArmeeRestantes(j3,choix41,19);
						p.placementArmeeRestantes(j4,choix41,19);
						
						while(choix41==1) { //boucle infinie
							System.out.println("joueur" + 1 + " place");
							int r1=j1.verif_region(j1);
							j1.initialisation(choix41,j1, 3+r1); // placement des arm�es du joueur 1
							System.out.println("le joueur1 attaque");
							j1.phase_attaque(1, j1, j2,j3, null, null, null); // phase attaque du joueur 1
							System.out.println("le joueur1 d�place");
							j1.deplacement(1, j1); // phase d�placement du joueur 1
							j1.verification_mission(j1.getMission(), j1);
							
							int r2=j2.verif_region(j2);
							System.out.println("joueur" + 2 + " place");
							j2.initialisation(choix41,j2, 3+r2); // placement des arm�es du joueur 2
							System.out.println("le joueur2 attaque");
							j2.phase_attaque(1, j2, j1, j3, null, null, null); // phase attaque du joueur 2
							System.out.println("le joueur2 d�place");
							j2.deplacement(1, j2); // phase d�placement du joueur 2
							j2.verification_mission(j2.getMission(), j2);
							
							int r3=j3.verif_region(j3);
							System.out.println("joueur" + 3 + " place");
							j3.initialisation(choix41,j3, 3+r3); // placement des arm�es du joueur 3
							System.out.println("le joueur3 attaque");
							j3.phase_attaque(1, j3, j1, j2, null, null, null); // phase attaque du joueur 3
							System.out.println("le joueur3 d�place");
							j3.deplacement(1, j3); // phase d�placement du joueur 3
							j3.verification_mission(j3.getMission(), j3);
							
							int r4=j4.verif_region(j4);
							System.out.println("joueur" + 4 + " place");
							j4.initialisation(choix41,j4, 3+r4); // placement des arm�es du joueur 4
							System.out.println("le joueur4 attaque");
							j4.phase_attaque(1, j4, j1, j2, j3, null, null); // phase attaque du joueur 4
							System.out.println("le joueur4 d�place");
							j4.deplacement(1, j4); // phase d�placement du joueur 4
							j4.verification_mission(j4.getMission(), j4);
						}
						break;
				}
			}
		}
			
/* ----------------------------- Initialisation pour 5 JOUEURS ----------------------------- */
			
			while (choix3 == 5) {
				if (StdDraw.mousePressed()) {
					int choix41=1;
					if (StdDraw.mousePressed()) {
						int armee = 25;
						Partie p = new Partie(42, choix3);
						View.afficher_map();
						
						// cr�ation joueurs
						Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null, "Image/J1.png");
						Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null, "Image/J2.png");
						Joueur j3 = new Joueur(0, 3, StdDraw.RED, "rouge", null, "Image/J3.png");
						Joueur j4 = new Joueur(0, 4, StdDraw.ORANGE, "orange", null, "Image/J4.png");
						Joueur j5 = new Joueur(0, 5, StdDraw.MAGENTA, "magenta", null, "Image/J5.png");
												
						// attribution de la mission au joueur 1
						mission.Chat_Box_Mission(j1,p);
						StdDraw.clear();
						View.afficher_map();
						
						// attribution de la mission au joueur 2
						mission.Chat_Box_Mission(j2,p);
						StdDraw.clear();
						View.afficher_map();
						
						// attribution de la mission au joueur 3
						mission.Chat_Box_Mission(j3,p);
						StdDraw.clear();
						View.afficher_map(); 
						
						// attribution de la mission au joueur 4
						mission.Chat_Box_Mission(j4,p);
						StdDraw.clear();
						View.afficher_map();
						
						// attribution de la mission au joueur 5
						mission.Chat_Box_Mission(j5,p);
						StdDraw.clear();
						View.afficher_map();
						
						// liste al�atoire des territoires
						ArrayList l = new ArrayList<Integer>();
						l = p.randomAvecExclusion(1, 43);
						// d�coupage de la liste selon le nombre de joueurs
						List l1 = l.subList(0, 8);
						List l2 = l.subList(8, 16);
						List l3 = l.subList(16, 24);
						List l4 = l.subList(24, 33);
						List l5 = l.subList(33, 42);
						
						// attribuer les territoires aux joueurs
						p.ajouter_teritoire(j1, l1);
						p.ajouter_teritoire(j2, l2);
						p.ajouter_teritoire(j3, l3);
						p.ajouter_teritoire(j4, l4);
						p.ajouter_teritoire(j5, l5);
						
						// affichage des territoires des joueurs
						j1.territoire_joueur();
						j2.territoire_joueur();
						j3.territoire_joueur();
						j4.territoire_joueur();
						j5.territoire_joueur();

						p.placementArmeeRestantes(j1,choix41,17);
						p.placementArmeeRestantes(j2,choix41,17);
						p.placementArmeeRestantes(j3,choix41,17);
						p.placementArmeeRestantes(j4,choix41,16);
						p.placementArmeeRestantes(j5,choix41,16);
						
						while(choix41==1) { //boucle infinie
							System.out.println("joueur" + 1 + " place");
							int r1=j1.verif_region(j1);
							j1.initialisation(choix41,j1, 3+r1); // placement des arm�es du joueur 1
							System.out.println("le joueur1 attaque");
							j1.phase_attaque(1, j1, j2,j3, j4, j5, null); // phase attaque du joueur 1
							System.out.println("le joueur1 d�place");
							j1.deplacement(1, j1); // phase d�placement du joueur 1
							j1.verification_mission(j1.getMission(), j1);
							
							int r2=j2.verif_region(j2);
							System.out.println("joueur" + 2 + " place");
							j2.initialisation(choix41,j2, 3+r2); // placement des arm�es du joueur 2
							System.out.println("le joueur2 attaque");
							j2.phase_attaque(1, j2, j1, j3, j4, j5, null); // phase attaque du joueur 2
							System.out.println("le joueur2 d�place");
							j2.deplacement(1, j2); // phase d�placement du joueur 2
							j2.verification_mission(j2.getMission(), j2);
							
							int r3=j3.verif_region(j3);
							System.out.println("joueur" + 3 + " place");
							j3.initialisation(choix41,j3, 3+r3); // placement des arm�es du joueur 3
							System.out.println("le joueur3 attaque");
							j3.phase_attaque(1, j3, j1, j2, j4, j5, null); // phase attaque du joueur 3
							System.out.println("le joueur3 d�place");
							j3.deplacement(1, j3); // phase d�placement du joueur 3
							j3.verification_mission(j3.getMission(), j3);
							
							int r4=j4.verif_region(j4);
							System.out.println("joueur" + 4 + " place");
							j4.initialisation(choix41,j4, 3+r4); // placement des arm�es du joueur 4
							System.out.println("le joueur4 attaque");
							j4.phase_attaque(1, j4, j1, j2, j3, j5, null); // phase attaque du joueur 4
							System.out.println("le joueur4 d�place");
							j4.deplacement(1, j4); // phase d�placement du joueur 4
							j4.verification_mission(j4.getMission(), j4);
							
							int r5=j5.verif_region(j5);
							System.out.println("joueur" + 5 + " place");
							j5.initialisation(choix41,j5, 3+r5); // placement des arm�es du joueur 5
							System.out.println("le joueur5 attaque");
							j5.phase_attaque(1, j5, j1, j2, j3, j4, null); // phase attaque du joueur 5
							System.out.println("le joueur5 d�place");
							j5.deplacement(1, j5); // phase d�placement du joueur 5
							j5.verification_mission(j5.getMission(), j5);
						}
						break;
				}
			}
		}	
			
			
/* ----------------------------- Initialisation pour 6 JOUEURS ----------------------------- */
			
			while (choix3 == 6) {
				if (StdDraw.mousePressed()) {
					int choix41=1;
					if (StdDraw.mousePressed()) {
						int armee = 20;
						Partie p = new Partie(42, choix3);
						View.afficher_map();
						
						// cr�ation joueurs
						Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null, "Image/J1.png");
						Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null, "Image/J2.png");
						Joueur j3 = new Joueur(0, 3, StdDraw.RED, "rouge", null, "Image/J3.png");
						Joueur j4 = new Joueur(0, 4, StdDraw.ORANGE, "orange", null, "Image/J4.png");
						Joueur j5 = new Joueur(0, 5, StdDraw.PINK, "rose", null, "Image/J5.png");
						Joueur j6 = new Joueur(0, 5, StdDraw.BOOK_LIGHT_BLUE, "bleu clair", null, "Image/J6.png");
												
						// attribution de la mission au joueur 1
						mission.Chat_Box_Mission(j1,p);
						StdDraw.clear();
						View.afficher_map();
						
						// attribution de la mission au joueur 2
						mission.Chat_Box_Mission(j2,p);
						StdDraw.clear();
						View.afficher_map();
						
						// attribution de la mission au joueur 3
						mission.Chat_Box_Mission(j3,p);
						StdDraw.clear();
						View.afficher_map(); 
						
						// attribution de la mission au joueur 4
						mission.Chat_Box_Mission(j4,p);
						StdDraw.clear();
						View.afficher_map();
						
						// attribution de la mission au joueur 5
						mission.Chat_Box_Mission(j5,p);
						StdDraw.clear();
						View.afficher_map();
						
						// attribution de la mission au joueur 6
						mission.Chat_Box_Mission(j6,p);
						StdDraw.clear();
						View.afficher_map();
						
						// liste al�atoire des territoires
						ArrayList l = new ArrayList<Integer>();
						l = p.randomAvecExclusion(1, 43);
						
						// d�coupage de la liste selon le nombre de joueurs
						List l1 = l.subList(0, 7);
						List l2 = l.subList(7, 14);
						List l3 = l.subList(14, 21);
						List l4 = l.subList(21, 28);
						List l5 = l.subList(28, 35);
						List l6 = l.subList(35, 42);
						
						// attribuer les territoires aux joueurs
						p.ajouter_teritoire(j1, l1);
						p.ajouter_teritoire(j2, l2);
						p.ajouter_teritoire(j3, l3);
						p.ajouter_teritoire(j4, l4);
						p.ajouter_teritoire(j5, l5);
						p.ajouter_teritoire(j6, l6);
						
						// affichage des territoires des joueurs
						j1.territoire_joueur();
						j2.territoire_joueur();
						j3.territoire_joueur();
						j4.territoire_joueur();
						j5.territoire_joueur();
						j6.territoire_joueur();

						p.placementArmeeRestantes(j1,choix41,13);
						p.placementArmeeRestantes(j2,choix41,13);
						p.placementArmeeRestantes(j3,choix41,13);
						p.placementArmeeRestantes(j4,choix41,13);
						p.placementArmeeRestantes(j5,choix41,13);
						p.placementArmeeRestantes(j6,choix41,13);
						
						while(choix41==1) { //boucle infinie
							System.out.println("joueur" + 1 + " place");
							int r1=j1.verif_region(j1);
							j1.initialisation(choix41,j1, 3+r1); // placement des arm�es du joueur 1
							System.out.println("le joueur1 attaque");
							j1.phase_attaque(1, j1, j2,j3, j4, j5, j6); // phase attaque du joueur 1
							System.out.println("le joueur1 d�place");
							j1.deplacement(1, j1); // phase d�placement du joueur 1
							j1.verification_mission(j1.getMission(), j1);
							
							int r2=j2.verif_region(j2);
							System.out.println("joueur" + 2 + " place");
							j2.initialisation(choix41,j2, 3+r2); // placement des arm�es du joueur 2
							System.out.println("le joueur2 attaque");
							j2.phase_attaque(1, j2, j1, j3, j4, j5, j6); // phase attaque du joueur 2
							System.out.println("le joueur2 d�place");
							j2.deplacement(1, j2); // phase d�placement du joueur 2
							j2.verification_mission(j2.getMission(), j2);
							
							int r3=j3.verif_region(j3);
							System.out.println("joueur" + 3 + " place");
							j3.initialisation(choix41,j3, 3+r3); // placement des arm�es du joueur 3
							System.out.println("le joueur3 attaque");
							j3.phase_attaque(1, j3, j1, j2, j4, j5, j6); // phase attaque du joueur 3
							System.out.println("le joueur3 d�place");
							j3.deplacement(1, j3); // phase d�placement du joueur 3
							j3.verification_mission(j3.getMission(), j3);
							
							int r4=j4.verif_region(j4);
							System.out.println("joueur" + 4 + " place");
							j4.initialisation(choix41,j4, 3+r4); // placement des arm�es du joueur 4
							System.out.println("le joueur4 attaque");
							j4.phase_attaque(1, j4, j1, j2, j3, j5, j6); // phase attaque du joueur 4
							System.out.println("le joueur4 d�place");
							j4.deplacement(1, j4); // phase d�placement du joueur 4
							j4.verification_mission(j4.getMission(), j4);
							
							int r5=j5.verif_region(j5);
							System.out.println("joueur" + 5 + " place");
							j5.initialisation(choix41,j5, 3+r5); // placement des arm�es du joueur 5
							System.out.println("le joueur5 attaque");
							j5.phase_attaque(1, j5, j1, j2, j3, j4, j6); // phase attaque du joueur 5
							System.out.println("le joueur5 d�place");
							j5.deplacement(1, j5); // phase d�placement du joueur 5
							j5.verification_mission(j5.getMission(), j5);
							
							int r6=j6.verif_region(j6);
							System.out.println("joueur" + 6 + " place");
							j6.initialisation(choix41,j6, 3+r6); // placement des arm�es du joueur 6
							System.out.println("le joueur6 attaque");
							j6.phase_attaque(1, j6, j1, j2, j3, j4, j5); // phase attaque du joueur 6
							System.out.println("le joueur6 d�place");
							j6.deplacement(1, j6); // phase d�placement du joueur 6
							j6.verification_mission(j6.getMission(), j6);
						}
						break;
				}
				}
			}
					
/* ----------------------------- Initialisation pour 1 JOUEUR et 1 IA ----------------------------- */	
			
			while (choix3 == 11) {
				if (StdDraw.isMousePressed()) {
					// Affichage des deux personnages � choisir
					View.affichage_personnage(2, "Image/Napopo.png", "Image/wellington.png", null);
					View.afficherImage(60,55,"Image/versus.png");
					StdDraw.text(60, 100, "Choisissez le personnage de l'IA");
					choix3=0;
					choix4 = 0;
				}
				
				while (choix4 != 1) {
					if (StdDraw.mousePressed()) {
						// Affichage du personnage restant en fonction du choix pr�c�dent
						double x = StdDraw.mouseX();
						double y = StdDraw.mouseY();
						if (15 < x && x < 55) {
							View.affichage_personnage(1, "Image/wellington.png", null, null);
							StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
							persoj1="Image/Napopo_petit.png";
							persoj2="Image/wellington_petit.png";
							choix5 = 11;
							break;
						} else if (55 < x && x < 105) {
							View.affichage_personnage(1, "Image/Napopo.png", null, null);
							StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
							choix5 = 11;
							persoj1="Image/wellington_petit.png";
							persoj2="Image/Napopo_petit.png";
							break;
						} else {
							View.affichage_personnage(2, "Image/Napopo.png", "Image/wellington.png", null);
							StdDraw.text(60, 100, "Choisissez le personnage de l'IA");
							View.afficherImage(60,55,"Image/versus.png");
							choix4 = 0;
						}
					} else {
					}
				}
			}
			
			// Lancement de la partie
			while (choix5 == 11) {
				if (StdDraw.mousePressed()) {
					int armee = 40;
					int choix41 = 1;
					
					// Cr�ation et affichage de la carte
					Partie p = new Partie(42, 2);
					View.afficher_map();
					
					// Cr�ation des joueurs
					Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null, persoj1);
					Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null, persoj2);
					IA ia = new IA(j1,p);

					// Attribution de la mission au joueur 1
					mission.Chat_Box_Mission(j1,p);
					StdDraw.clear();
					View.afficher_map(); // on r�-affiche la carte

					// Attribution de la mission au joueur 2
					mission.Chat_Box_Mission(j2,p);
					StdDraw.clear();
					View.afficher_map(); // on r�-affiche la carte

					// Cr�ation de la liste des territoires
					ArrayList l = new ArrayList<territoire>();
					l = p.randomAvecExclusion(1, 43);
					
					// D�coupage de la liste selon le nombre de joueurs
					List<territoire> l1 = l.subList(0, 21);
					List<territoire> l2 = l.subList(21, 42);
					
					// Attribution des territoires aux joueurs
					p.ajouter_teritoire(j1, l1);
					p.ajouter_teritoire(j2, l2);
					
					// Affichage des territoires et arm�es des joueurs
					j1.territoire_joueur();
					j2.territoire_joueur();
					
					//Partie.placementArmeeRestantes(j1, choix41);
					ia.IA_placementArmeeRestantes(j1, 19);
					p.placementArmeeRestantes(j2, choix41,19);
					
					while(choix41==1) { // boucle infinie
						int r1=j1.verif_region(j1);
						ia.IA_initialisation(j1, 3+r1);
						ia.IA_phase_attaque(1, j1, j2, null, null, null, null);
						ia.IA_deplacement(j1);
						j1.verification_mission(j1.getMission(), j1);
						
						int r2=j2.verif_region(j2);
						j2.initialisation(choix41,j2, 3+r2); // placement des arm�es du joueur 2
						j2.phase_attaque(1, j2, j1, null, null, null, null); // phase attaque du joueur 2
						j2.deplacement(1, j2); // phase d�placement du joueur 2
						j2.verification_mission(j2.getMission(), j2);
					}

					break;
				}
			}
			
/* ------------------------------------- Initialisation pour 1 JOUEUR et 2 IA ------------------------------------- */

			while (choix3 == 12) {
				if (StdDraw.isMousePressed()) {
					// Affichage des deux personnages � choisir
					View.affichage_personnage(3, "Image/Napopo.png", "Image/cesar.png", "Image/wellington.png");
					View.afficherImage(39,55,"Image/versus.png");
					View.afficherImage(82,55,"Image/versus.png");
					StdDraw.text(60, 100, "Choisissez le personnage de l'IA 1");
					choix3=0;
					choix4 = 0;
				}
				
				while (choix4 != 1) {
					if (StdDraw.mousePressed()) {
						// Affichage du personnage restant en fonction du choix pr�c�dent
						double x = StdDraw.mouseX();
						double y = StdDraw.mouseY();
						if (5 < x && x < 35) {
							persoj1="Image/Napopo_petit.png";
							View.affichage_personnage(2, "Image/cesar.png", "Image/wellington.png", null);
							View.afficherImage(60,55,"Image/versus.png");
							StdDraw.text(60, 100, "Choisissez le personnage de l'IA 2");
							while (choix10 != 1) {
								if (StdDraw.mousePressed()) {
								double x1 = StdDraw.mouseX();
								double y1 = StdDraw.mouseY();
								if (15 < x1 && x1 < 55) {
									View.affichage_personnage(1, "Image/wellington.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 12;
									persoj3="Image/wellington_petit.png";
									persoj2="Image/cesar_petit.png";
									break;
								} else if (55 < x1 && x1 < 105) {
									View.affichage_personnage(1, "Image/cesar.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 12;
									persoj2="Image/wellington_petit.png";
									persoj3="Image/cesar_petit.png";
									break;
								} else {
									View.affichage_personnage(2, "Image/cesar.png", "Image/wellington.png", null);
									View.afficherImage(60,55,"Image/versus.png");
									StdDraw.text(60, 100, "Choisissez le personnage de l'IA 2");
									choix4 = 0;
								}
								}
							}
							break;
						} 
						
						else if (45 < x && x < 75) {
							persoj1="Image/cesar_petit.png";
							View.affichage_personnage(2, "Image/Napopo.png", "Image/wellington.png", null);
							View.afficherImage(60,55,"Image/versus.png");
							StdDraw.text(60, 100, "Choisissez le personnage de l'IA 2");
							while (choix10 != 1) {
								if (StdDraw.mousePressed()) {
								double x1 = StdDraw.mouseX();
								double y1 = StdDraw.mouseY();
								if (15 < x1 && x1 < 55) {
									View.affichage_personnage(1, "Image/wellington.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 12;
									persoj3="Image/wellington_petit.png";
									persoj2="Image/Napopo_petit.png";
									break;
								} else if (55 < x1 && x1 < 105) {
									View.affichage_personnage(1, "Image/Napopo.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 12;
									persoj2="Image/wellington_petit.png";
									persoj3="Image/Napopo_petit.png";
									break;
								} else {
									View.affichage_personnage(2, "Image/Napopo.png", "Image/wellington.png", null);
									View.afficherImage(60,55,"Image/versus.png");
									StdDraw.text(60, 100, "Choisissez le personnage de l'IA 2");
									choix4 = 0;
								}
								}
							}
							break;
						} 
						
						
						else if (85 < x && x < 115) {
							persoj1="Image/wellington_petit.png";
							View.affichage_personnage(2, "Image/Napopo.png", "Image/cesar.png", null);
							View.afficherImage(60,55,"Image/versus.png");
							StdDraw.text(60, 100, "Choisissez le personnage de l'IA 2");
							while (choix10 != 1) {
								if (StdDraw.mousePressed()) {
								double x1 = StdDraw.mouseX();
								double y1 = StdDraw.mouseY();
								if (15 < x1 && x1 < 55) {
									View.affichage_personnage(1, "Image/cesar.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 12;
									persoj2="Image/Napopo_petit.png";
									persoj3="Image/cesar_petit.png";
									break;
								} else if (55 < x1 && x1 < 105) {
									View.affichage_personnage(1, "Image/Napopo.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 12;
									persoj3="Image/Napopo_petit.png";
									persoj2="Image/cesar_petit.png";
									break;
								} else {
									View.affichage_personnage(2, "Image/Napopo.png", "Image/cesar.png", null);
									StdDraw.text(60, 100, "Choisissez le personnage de l'IA 2");
									choix4 = 0;
								}
								}
							}
							break;
						}
						else {
							// Affichage des deux personnages � choisir
							View.affichage_personnage(3, "Image/Napopo.png", "Image/cesar.png", "Image/wellington.png");
							View.afficherImage(39,55,"Image/versus.png");
							View.afficherImage(82,55,"Image/versus.png");
							StdDraw.text(60, 100, "Choisissez le personnage de l'IA 1");
							choix4 = 0;
						}
					} else {
					}
				}
			}
			
			
			while (choix5 == 12) {
				if (StdDraw.mousePressed()) {
					int armee = 35;
					int choix41=1;
					
					Partie p = new Partie(42, 3); // cr�ation de la carte
					View.afficher_map(); // affichage de la carte
					// cr�ation joueurs
					Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null, persoj1);
					Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null, persoj2);
					Joueur j3 = new Joueur(0, 3, StdDraw.RED, "rouge", null, persoj3);
					IA ia1 = new IA(j1,p);
					IA ia2 = new IA(j2,p);
					
					// attribution de la mission au joueur 1
					mission.Chat_Box_Mission(j1,p);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on r�-affiche la carte

					// attribution de la mission au joueur 2
					mission.Chat_Box_Mission(j2,p);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on r�-affiche la carte
					
					// attribution de la mission au joueur 3
					mission.Chat_Box_Mission(j3,p);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on r�-affiche la carte
					
					// liste al�atoire des territoires
					ArrayList l = new ArrayList<territoire>();
					l = p.randomAvecExclusion(1, 43);
					
					// d�coupage de la liste selon le nombre de joueurs
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
					
					ia1.IA_placementArmeeRestantes(j1, 21);
					ia2.IA_placementArmeeRestantes(j2, 21);
					p.placementArmeeRestantes(j3,choix41,21);

					while(choix41==1) { // boucle infinie
						int r1=j1.verif_region(j1);
						ia1.IA_initialisation(j1, 3+r1);
						ia1.IA_phase_attaque(1, j1, j2, j3, null, null, null);
						ia1.IA_deplacement(j1);
						j1.verification_mission(j1.getMission(), j1);
						
						int r2=j2.verif_region(j2);
						ia2.IA_initialisation(j2, 3+r2);
						ia2.IA_phase_attaque(1, j2, j1, j3, null, null, null);
						ia2.IA_deplacement(j2);
						j2.verification_mission(j2.getMission(), j2);
						
						int r3=j3.verif_region(j3);
						System.out.println("joueur" + 3 + " place");
						j3.initialisation(choix41,j3, 3+r3); // placement des arm�es du joueur 3
						System.out.println("le joueur3 attaque");
						j3.phase_attaque(1, j3, j1, j2, null, null, null); // phase attaque du joueur 3
						System.out.println("le joueur3 d�place");
						j3.deplacement(1, j3); // phase d�placement du joueur 3
						j3.verification_mission(j3.getMission(), j3);
					}
					break;
				}
			}
				
		
/* ------------------------------------- Initialisation pour 2 JOUEURS et 1 IA ------------------------------------- */

			while (choix3 == 21) {
				if (StdDraw.isMousePressed()) {
					// Affichage des deux personnages � choisir
					View.affichage_personnage(3, "Image/Napopo.png", "Image/cesar.png", "Image/wellington.png");
					View.afficherImage(39,55,"Image/versus.png");
					View.afficherImage(82,55,"Image/versus.png");
					StdDraw.text(60, 100, "Choisissez le personnage de l'IA 1");
					choix3=0;
					choix4 = 0;
				}
				
				while (choix4 != 1) {
					if (StdDraw.mousePressed()) {
						// Affichage du personnage restant en fonction du choix pr�c�dent
						double x = StdDraw.mouseX();
						double y = StdDraw.mouseY();
						if (5 < x && x < 35) {
							persoj1="Image/Napopo_petit.png";
							View.affichage_personnage(2, "Image/cesar.png", "Image/wellington.png", null);
							View.afficherImage(60,55,"Image/versus.png");
							StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
							while (choix10 != 1) {
								if (StdDraw.mousePressed()) {
								double x1 = StdDraw.mouseX();
								double y1 = StdDraw.mouseY();
								if (15 < x1 && x1 < 55) {
									View.affichage_personnage(1, "Image/wellington.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 21;
									persoj3="Image/wellington_petit.png";
									persoj2="Image/cesar_petit.png";
									break;
								} else if (55 < x1 && x1 < 105) {
									View.affichage_personnage(1, "Image/cesar.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 21;
									persoj2="Image/wellington_petit.png";
									persoj3="Image/cesar_petit.png";
									break;
								} else {
									View.affichage_personnage(2, "Image/cesar.png", "Image/wellington.png", null);
									View.afficherImage(60,55,"Image/versus.png");
									StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
									choix4 = 0;
								}
								}
							}
							break;
						} 
						
						else if (45 < x && x < 75) {
							persoj1="Image/cesar_petit.png";
							View.affichage_personnage(2, "Image/Napopo.png", "Image/wellington.png", null);
							View.afficherImage(60,55,"Image/versus.png");
							StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
							while (choix10 != 1) {
								if (StdDraw.mousePressed()) {
								double x1 = StdDraw.mouseX();
								double y1 = StdDraw.mouseY();
								if (15 < x1 && x1 < 55) {
									View.affichage_personnage(1, "Image/wellington.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 21;
									persoj3="Image/wellington_petit.png";
									persoj2="Image/Napopo_petit.png";
									break;
								} else if (55 < x1 && x1 < 105) {
									View.affichage_personnage(1, "Image/Napopo.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 21;
									persoj2="Image/wellington_petit.png";
									persoj3="Image/Napopo_petit.png";
									break;
								} else {
									View.affichage_personnage(2, "Image/Napopo.png", "Image/wellington.png", null);
									View.afficherImage(60,55,"Image/versus.png");
									StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
									choix4 = 0;
								}
								}
							}
							break;
						} 
						
						
						else if (85 < x && x < 115) {
							persoj1="Image/wellington_petit.png";
							View.affichage_personnage(2, "Image/Napopo.png", "Image/cesar.png", null);
							View.afficherImage(60,55,"Image/versus.png");
							StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
							while (choix10 != 1) {
								if (StdDraw.mousePressed()) {
								double x1 = StdDraw.mouseX();
								double y1 = StdDraw.mouseY();
								if (15 < x1 && x1 < 55) {
									View.affichage_personnage(1, "Image/cesar.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 21;
									persoj2="Image/Napopo_petit.png";
									persoj3="Image/cesar_petit.png";
									break;
								} else if (55 < x1 && x1 < 105) {
									View.affichage_personnage(1, "Image/Napopo.png", null, null);
									StdDraw.text(60, 100, "Joueur 3, choisissez votre personnage");
									choix5 = 21;
									persoj3="Image/Napopo_petit.png";
									persoj2="Image/cesar_petit.png";
									break;
								} else {
									View.affichage_personnage(2, "Image/Napopo.png", "Image/cesar.png", null);
									StdDraw.text(60, 100, "Joueur 2, choisissez votre personnage");
									choix4 = 0;
								}
								}
							}
							break;
						}
						else {
							// Affichage des deux personnages � choisir
							View.affichage_personnage(3, "Image/Napopo.png", "Image/cesar.png", "Image/wellington.png");
							View.afficherImage(39,55,"Image/versus.png");
							View.afficherImage(82,55,"Image/versus.png");
							StdDraw.text(60, 100, "Choisissez le personnage de l'IA 1");
							choix4 = 0;
						}
					} else {
					}
				}
			}
			
			
			while (choix5 == 21) {
				if (StdDraw.mousePressed()) {
					int armee = 35;
					int choix41=1;
					
					Partie p = new Partie(42, 3); // cr�ation de la carte
					View.afficher_map(); // affichage de la carte
					// cr�ation joueurs
					Joueur j1 = new Joueur(0, 1, StdDraw.BLUE, "bleu", null, persoj1);
					Joueur j2 = new Joueur(0, 2, StdDraw.GREEN, "vert", null, persoj2);
					Joueur j3 = new Joueur(0, 3, StdDraw.RED, "rouge", null, persoj3);
					IA ia1 = new IA(j1,p);
					
					// attribution de la mission au joueur 1
					mission.Chat_Box_Mission(j1,p);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on r�-affiche la carte

					// attribution de la mission au joueur 2
					mission.Chat_Box_Mission(j2,p);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on r�-affiche la carte
					
					// attribution de la mission au joueur 3
					mission.Chat_Box_Mission(j3,p);
					StdDraw.clear();// on supprime le message de mission
					View.afficher_map(); // on r�-affiche la carte
					
					// liste al�atoire des territoires
					ArrayList l = new ArrayList<territoire>();
					l = p.randomAvecExclusion(1, 43);
					
					// d�coupage de la liste selon le nombre de joueurs
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
					
					ia1.IA_placementArmeeRestantes(j1, 21);
					p.placementArmeeRestantes(j2,choix41,21);
					p.placementArmeeRestantes(j3,choix41,21);

					while(choix41==1) { // boucle infinie
						int r1=j1.verif_region(j1);
						ia1.IA_initialisation(j1, 3+r1);
						ia1.IA_phase_attaque(1, j1, j2, j3, null, null, null);
						ia1.IA_deplacement(j1);
						j1.verification_mission(j1.getMission(), j1);
						
						int r2=j2.verif_region(j2);
						j2.initialisation(choix41,j2, 3+r2); // placement des arm�es du joueur 3
						j2.phase_attaque(1, j2, j1, j2, null, null, null); // phase attaque du joueur 3
						j2.deplacement(1, j2); // phase d�placement du joueur 3
						j2.verification_mission(j2.getMission(), j2);
						
						int r3=j3.verif_region(j3);
						j3.initialisation(choix41,j3, 3+r3); // placement des arm�es du joueur 3
						j3.phase_attaque(1, j3, j1, j2, null, null, null); // phase attaque du joueur 3
						j3.deplacement(1, j3); // phase d�placement du joueur 3
						j3.verification_mission(j3.getMission(), j3);
					}
					break;
				}

			}
			
			
		}		
						
					
	}
}
