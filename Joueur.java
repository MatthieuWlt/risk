import java.awt.Color;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

import edu.princeton.cs.introcs.StdDraw;

public class Joueur {
	public int mission;
	public int numero;
	Color couleur;
	String nomcoul;
	public ArrayList<territoire> list_ter;

	public Joueur(int mission, int numero, Color couleur, String nomcoul, ArrayList<territoire> list_ter) {
		this.mission = mission;
		this.numero = numero;
		this.couleur = couleur;
		this.nomcoul = nomcoul;
		this.list_ter = new ArrayList<territoire>();
	}

	public int getMission() {
		return mission;
	}

	public void setMission(int mission) {
		this.mission = mission;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<territoire> getList_ter() {
		return list_ter;
	}

	public void setList_ter(ArrayList<territoire> list_ter) {
		this.list_ter = list_ter;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getNomcoul() {
		return nomcoul;
	}

	public void setNomcoul(String nomcoul) {
		this.nomcoul = nomcoul;
	}

	public void recupere_mission() {

	}

	public ArrayList<Integer> affiche_list() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < list_ter.size(); i++) {
			territoire t = list_ter.get(i);
			int e = t.getNumero();
			list.add(e);
		}
		return list;
	}

	public void affiche() {
		System.out.println("Joueur" + numero + " : " + affiche_list() + "\n" + "Couleur : " + nomcoul);
	}

	public void territoire_joueur() {
		int a;
		int b = 0;
		Random rand = new Random();
		for (int i = 0; i < list_ter.size(); i++) {
			territoire y = (territoire) list_ter.get(i);
			b = b++;
			y.position(y, couleur);
		}
	}

	public void armee_joueur(int x) {
		Random rand = new Random();
		int w = 1;
		while (w != x + 1 - list_ter.size()) {
			territoire g = (territoire) list_ter.get(rand.nextInt(list_ter.size() - 0) + 0);
			add_armee(g, 1);
			g.position(g, couleur);
			w++;
		}
	}

	public void add_armee(territoire t, int p) {
		int r = t.getA();
		r = r + p;
		t.setA(r);
	}

	public void sup_armee(territoire t, int p) {
		int r = t.getA();
		r = r - p;
		t.setA(r);
	}

	public void attribution_mission(int numero_mission, int choix, Joueur j) {
		Random rand = new Random();
		JOptionPane jop1;// on definit notre objet pour le pop up
		jop1 = new JOptionPane();// on le cree
		ImageIcon img = new ImageIcon("Image/haches.png");// on ajoute une image

		switch (numero_mission) {

		case 1:
			/*--------------- VERIFICATION DU JOUEUR A DETRUIRE -----------*/
			int detruire = rand.nextInt((choix+1) -1)+1;//on choisit le joueur à détruire
			
			while(detruire == j.getNumero()){//tant que le joueur choisi est le meme que celui qui joue,
				int detruire2 = rand.nextInt((choix+1) -1)+1;//on rechoisit un nouveau joueur
				detruire=detruire2;//on affecte la nouvelle valeur
			}
			/* ----------------- FIN DE LA VERIFICATION ------------------ */
			jop1.showMessageDialog(null, "Le joueur " + j.getNumero() + " doit détruire le joueur "+ detruire+".",
					"Découvrez votre mission", JOptionPane.INFORMATION_MESSAGE, img);// partie pup-up
			break;

		case 2:
			jop1.showMessageDialog(null, "Le joueur " + j.getNumero() + " doit conquérir tous les territoires.",
					"Découvrez votre mission", JOptionPane.INFORMATION_MESSAGE, img);
			break;
		case 3:
			jop1.showMessageDialog(null,
					"Le joueur " + j.getNumero() + " doit contrôler 3 régions et au moins 18 territoires.",
					"Découvrez votre mission", JOptionPane.INFORMATION_MESSAGE, img);
			break;
		case 4:
			jop1.showMessageDialog(null,
					"Le joueur " + j.getNumero() + " doit contrôler 18 territoires avec au moins 2 armées.",
					"Découvrez votre mission", JOptionPane.INFORMATION_MESSAGE, img);
			break;
		case 5:
			jop1.showMessageDialog(null, "Le joueur " + j.getNumero() + " doit contrôler contrôler 30 territoires.",
					"Découvrez votre mission", JOptionPane.INFORMATION_MESSAGE, img);
			break;
		case 6:
			jop1.showMessageDialog(null, "Le joueur " + j.getNumero() + " doit contrôler 24 territoires.",
					"Découvrez votre mission", JOptionPane.INFORMATION_MESSAGE, img);
			break;
		case 7:
			jop1.showMessageDialog(null, "Le joueur " + j.getNumero() + " doit contrôler 21 territoires.",
					"Découvrez votre mission", JOptionPane.INFORMATION_MESSAGE, img);
			break;
		case 8:
			jop1.showMessageDialog(null,
					"Le joueur " + j.getNumero() + " doit contrôler la plus grosse région plus une autre région.",
					"Découvrez votre mission", JOptionPane.INFORMATION_MESSAGE, img);
			break;
		}
	}
	
	public void verification_mission(int numero_mission,Joueur j) {
		switch(numero_mission) {
		case 1:
			if(getList_ter()==null) {
				StdDraw.text(60, 105, "Le joueur "+j.getNumero()+ " a gagné !");//on vérifie que le joueur adverse n'ai plus de territoire
			}
			else {
				//s'il a encore des territoires, le jeux continue
			}
			break;
		case 2:
			if((getList_ter()).size()==42) {
				StdDraw.text(60, 105, "Le joueur "+j.getNumero()+" a gagné !");//on vérifie si le joueur a tous les territoires
			}
			else {
				//s'il n'a pas tous les territoires le jeux continue
			}
			break;
		case 3:
			
			break;
			
		case 4://doit contrôler 18 territoires avec au moins 2 armées
			/*if ((getList_ter()).size()>=18) {
				for(int i=0;i<getList_ter().size();i++) {
					if(territoire.getA() < 2) {
						StdDraw.text(60, 105, "Le joueur "+j.getNumero()+" a gagné !");
					}
					else {
						
					}
				}
			}
			else {
				//le joueur n'a pas plus de 18 territoires
			}*/
			break;
			
		case 5:
			if(getList_ter().size()>=30) {
				StdDraw.text(60, 105, "Le joueur "+j.getNumero()+" a gagné !");//si le joueur a 30 territoires il a gagné
			}
			else {
				//le joueur n'a pas gagné car il n'a pas 30 territoires
			}
			break;
			
		case 6:
			if(getList_ter().size()>=24) {
				StdDraw.text(60, 105, "Le joueur "+j.getNumero()+" a gagné !");//si le joueur a 24 territoires il a gagné
			}
			else {
				//le joueur n'a pas gagné car il n'a pas 24 territoires
			}
			break;
			
		case 7:
			if(getList_ter().size()>=21) {
				StdDraw.text(60, 105, "Le joueur "+j.getNumero()+" a gagné !");//si le joueur a 21 territoires il a gagné
			}
			else {
				//le joueur n'a pas gagné car il n'a pas 21 territoires
			}
			break;
			
		case 8:
			break;
		}
	}

	public territoire recherche_ter(int num, Joueur j) {
		for (int i = 0; i < j.list_ter.size(); i++) {
			territoire h = j.list_ter.get(i);
			int n = h.getNumero();
			if (n == num) {
				return h;
			}
		}
		return null;
	}

	public territoire choix_pays(int choix4, Joueur j) {
		// ArrayList<territoire> list_ter=j.list_ter;
		// while (choix4==1) {
		// if (StdDraw.mousePressed()) {
		double x = StdDraw.mouseX();
		double y = StdDraw.mouseY();
		// Amérique
		if (86.1 < y && y < 91.3 && 4.7 < x && x < 9.7) {
			territoire t = recherche_ter(1, j);
			return t;
		} else if (78.4 < y && y < 83.6 && 9.6 < x && x < 14.6) {
			territoire t = recherche_ter(2, j);
			return t;
		} else if (56.3 < y && y < 61.5 && 9.3 < x && x < 14.3) {
			territoire t = recherche_ter(3, j);
			return t;
		} else if (15.4 < x && x < 20.4 && 67 < y && y < 72.2) {
			territoire t = recherche_ter(4, j);
			return t;
		} else if (33.3 < x && x < 38.3 && 90.4 < y && y < 95.6) {
			territoire t = recherche_ter(5, j);
			return t;
		} else if (12.8 < x && x < 17.8 && 85.7 < y && y < 90.9) {
			territoire t = recherche_ter(6, j);
			return t;
		} else if (16.8 < x && x < 21.8 && 78.3 < y && y < 83.5) {
			territoire t = recherche_ter(7, j);
			return t;
		} else if (23.6 < x && x < 28.6 && 77.3 < y && y < 82.5) {
			territoire t = recherche_ter(8, j);
			return t;
		} else if (8.9 < x && x < 13.9 && 69.4 < y && y < 74.6) {
			territoire t = recherche_ter(9, j);
			return t;
		}
		// Amérique du sud
		else if (22.3 < x && x < 26.3 && 17.7 < y && y < 21.7) {
			territoire t = recherche_ter(10, j);
			return t;
		} else if (25.9 < x && x < 29.9 && 32.5 < y && y < 36.5) {
			territoire t = recherche_ter(11, j);
			return t;
		} else if (21.2 < x && x < 25.2 && 28.9 < y && y < 32.9) {
			territoire t = recherche_ter(12, j);
			return t;
		} else if (20.5 < x && x < 24.5 && 45.2 < y && y < 49.2) {
			territoire t = recherche_ter(13, j);
			return t;
		}
		// Afrique
		else if (50.1 < x && x < 54.1 && 40.2 < y && y < 44.2) {
			territoire t = recherche_ter(14, j);
			return t;
		} else if (56.6 < x && x < 60.6 && 46.6 < y && y < 50.6) {
			territoire t = recherche_ter(15, j);
			return t;
		} else if (50.5 < x && x < 54.5 && 60.7 < y && y < 64.7) {
			territoire t = recherche_ter(16, j);
			return t;
		} else if (58.7 < x && x < 62.7 && 26.2 < y && y < 30.2) {
			territoire t = recherche_ter(17, j);
			return t;
		} else if (42.6 < x && x < 46.6 && 53.6 < y && y < 57.6) {
			territoire t = recherche_ter(18, j);
			return t;
		} else if (50.5 < x && x < 54.5 && 26.2 < y && y < 30.2) {
			territoire t = recherche_ter(19, j);
			return t;
		}
		// Europe
		else if (42.3 < x && x < 46.3 && 79 < y && y < 83) {
			territoire t = recherche_ter(20, j);
			return t;
		} else if (38.7 < x && x < 42.7 && 84.6 < y && y < 88.6) {
			territoire t = recherche_ter(21, j);
			return t;
		} else if (47.6 < x && x < 51.6 && 77.6 < y && y < 81.6) {
			territoire t = recherche_ter(22, j);
			return t;
		} else if (47.6 < x && x < 51.6 && 84.6 < y && y < 88.6) {
			territoire t = recherche_ter(23, j);
			return t;
		} else if (50.1 < x && x < 54.1 && 71.9 < y && y < 75.9) {
			territoire t = recherche_ter(24, j);
			return t;
		} else if (53.7 < x && x < 57.7 && 79.7 < y && y < 83.7) {
			territoire t = recherche_ter(25, j);
			return t;
		} else if (43.7 < x && x < 47.7 && 71.9 < y && y < 75.9) {
			territoire t = recherche_ter(26, j);
			return t;
		}
		// Océanie
		else if (90.1 < x && x < 94.1 && 21.9 < y && y < 25.9) {
			territoire t = recherche_ter(27, j);
			return t;
		} else if (81.9 < x && x < 85.9 && 41 < y && y < 45) {
			territoire t = recherche_ter(28, j);
			return t;
		} else if (90.9 < x && x < 94.9 && 36.7 < y && y < 40.7) {
			territoire t = recherche_ter(29, j);
			return t;
		} else if (83 < x && x < 87 && 21.2 < y && y < 25.2) {
			territoire t = recherche_ter(30, j);
			return t;
		}
		// Asie
		else if (63 < x && x < 67 && 72.6 < y && y < 76.6) {
			territoire t = recherche_ter(31, j);
			return t;
		} else if (75.1 < x && x < 79.1 && 64.2 < y && y < 68.2) {
			territoire t = recherche_ter(32, j);
			return t;
		} else if (68.7 < x && x < 72.7 && 57.9 < y && y < 61.9) {
			territoire t = recherche_ter(33, j);
			return t;
		} else if (75.5 < x && x < 79.5 && 79 < y && y < 83) {
			territoire t = recherche_ter(34, j);
			return t;
		} else if (88.3 < x && x < 92.3 && 67 < y && y < 71) {
			territoire t = recherche_ter(35, j);
			return t;
		} else if (85.1 < x && x < 89.1 && 86 < y && y < 90) {
			territoire t = recherche_ter(36, j);
			return t;
		} else if (56.9 < x && x < 60.9 && 64.2 < y && y < 68.2) {
			territoire t = recherche_ter(37, j);
			return t;
		} else if (76.6 < x && x < 80.6 && 72.6 < y && y < 76.6) {
			territoire t = recherche_ter(38, j);
			return t;
		} else if (77.3 < x && x < 81.3 && 52.2 < y && y < 56.2) {
			territoire t = recherche_ter(39, j);
			return t;
		} else if (68.4 < x && x < 72.4 && 86 < y && y < 90) {
			territoire t = recherche_ter(40, j);
			return t;
		} else if (62.6 < x && x < 66.6 && 83.2 < y && y < 87.2) {
			territoire t = recherche_ter(41, j);
			return t;
		} else if (76.2 < x && x < 80.2 && 86 < y && y < 90) {
			territoire t = recherche_ter(42, j);
			return t;
		} else {
			return null;
		}
		// break;
		// } else {
		// }
		// }

	}

	public void initialisation(int choix4, Joueur j, int c) {
		int i = 1;
		StdDraw.pause(500);
		while (choix4 != 0) {
			StdDraw.pause(50);
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(25, 105, "Chat-Box : ");//texte
			StdDraw.text(60, 105, "J"+j.getNumero()+", il vous reste " + (c - (i-1)) + " armées à placer" );
			if (StdDraw.mousePressed()) {

				territoire t = choix_pays(1, j);
				if (t == null) {
					initialisation(choix4, j, c - i + 1);
					break;
				}
				System.out.println("Il vous reste " + (c - i) + " armées à placer");
				
				add_armee(t, 1);
				i++;
				t.position(t, couleur);
				StdDraw.pause(500);
				if (c - i == -1) {
					break;
				}
			} else {
				// StdDraw.pause(500);
			}
		}
	}

	public int de(Joueur j) {
		Random rand = new Random();
		int r = rand.nextInt(6 - 1) + 1;
		return r;
	}

	public static void PrintTab(int tab[]) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " "); // on affiche chaque élément du tableau
		}
		System.out.println("");// sauter une ligne pour les différentes lignes du tableau
	}

	public static int[] Permuter(int tab[], int i, int j) {

		int tmp = tab[i]; // donne à la variable temporaire la valeur à échanger
		tab[i] = tab[j];// affecte une nouvelle valeur
		tab[j] = tmp; // échange la valeur
		return tab; // retourne le tableau avec des valeurs échangées
	}

	public static int[] TriaBulles(int tab[]) {
		for (int i = 1; i < tab.length; i++) { // on compare deux valeurs donc on crée deux variables
			for (int j = 0; j < tab.length - i; j++) {
				if (tab[j] < tab[j + 1]) { // on compare deux valeurs du tableau
					tab = Permuter(tab, j, j + 1); // permute si l'élément de droite est plus petit que celui de gauche
				}
			} // fin lorsque tous les éléments sont bien placés
		}
		return (tab); // affiche le tableau trié
	}

	public int[] att(Joueur j, territoire t) {
		int de1 = de(j);
		int de2 = de(j);
		int de3 = de(j);
		if (t.getA() == 2) {
			int[] att = { de1 };
			att = TriaBulles(att);
			return att;
		} else if (t.getA() == 3) {
			int[] att = { de1, de2, de3 };
			att = TriaBulles(att);
			return att;
		} else if (t.getA() > 3) {
			int[] att = { de1, de2, de3 };
			att = TriaBulles(att);
			return att;
		} else {
			return null;
		}
	}

	public int[] def(Joueur j, territoire t) {
		int de1 = de(j);
		int de2 = de(j);
		if (t.getA() == 1) {
			int[] def = { de1 };
			def = TriaBulles(def);
			return def;
		} else if (t.getA() >= 2) {
			int[] def = { de1, de2 };
			def = TriaBulles(def);
			return def;
		} else {
			return null;
		}
	}

	public void phase_attaque(int a, Joueur j1, Joueur j2) {
		while (a != 0) {
			if (StdDraw.mousePressed()) { // clique sur un des boutons à droite
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				if (105 < x && x < 115 && 77 < y && y < 83) { // lorsqu'on clique sur "attaque"
					System.out.println("choisir un pays");
					StdDraw.pause(500);
					while (a != 0) {
						if (StdDraw.mousePressed()) { // clique sur un territoire
							territoire t1 = choix_pays(1, j1); // selection du pays qui attaque
							t1.position(t1, StdDraw.YELLOW); // affichage du pays qui attaque
							System.out.println("choisir un pays à attaquer");
							StdDraw.pause(500);
							while (a != 0) {
								// System.out.println("choisir un pays à attaquer");
								if (StdDraw.mousePressed()) {// clique sur le territoire à attaquer
									territoire t2 = choix_pays(1, j2); // selection du pays à attaquer
									if (verif(t1, t2) == true) {
										int[] att = att(j1, t1); // résultat du dé joueur attaquant
										int[] def = def(j2, t2); // résultat du dé joueur defenseur
										System.out.println("attaque :");
										PrintTab(att);
										System.out.println("def :");
										PrintTab(def);
										if ((att.length == 3 && def.length == 2)
												|| (att.length == 2 && def.length == 2)) { // situation possible de
																							// combat
											if (att[0] > def[0] && att[1] <= def[1]
													|| att[0] <= def[0] && att[1] > def[1]) { // résultat possible aux
																								// dés
												System.out.println(
														"le Joueur" + j1.getNumero() + " gagne mais perd 1 unité");
												sup_armee(t2, 1); // suppression d'une unité sur le territoire du joueur
																	// défenseur
												sup_armee(t1, 1); // suppression d'une unité sur le territoire du joueur
																	// attaquant
												t2.position(t2, j2.getCouleur());
												t1.position(t1, j1.getCouleur());
											} else if (att[0] > def[0] && att[1] > def[1]) {
												System.out.println("le Joueur" + j1.getNumero() + " gagne");
												if (t2.getA() == 2) {
													sup_armee(t2, 2);
													add_armee(t2, (t1.getA() - 1)); // déplacement armée joueur
																					// attaquant
													sup_armee(t1, (t1.getA() - 1));
													j1.list_ter.add(t2); // ajout du territoire au joueur attaquant
													j2.list_ter.remove(t2); // suppression du territoire au joueur
																			// defenseur
													t2.position(t2, j1.getCouleur()); // affichage territoire conquis
													t1.position(t1, j1.getCouleur()); // affichage territoire attaquant
												} else if (t2.getA() > 2) {
													sup_armee(t2, 2);
													t2.position(t2, j2.getCouleur());
												}

											} else if (att[0] <= def[0] && att[1] <= def[1]) {
												sup_armee(t1, 2);
												t1.position(t1, j1.getCouleur());
											}
										} else if ((att.length == 3 && def.length == 1)
												|| (att.length == 2 && def.length == 1)
												|| (att.length == 1 && def.length == 1)) {
											if (att[0] > def[0]) {
												sup_armee(t2, 1);
												add_armee(t2, (t1.getA() - 1)); // déplacement armée joueur attaquant
												sup_armee(t1, (t1.getA() - 1));
												j1.list_ter.add(t2); // ajout du territoire au joueur attaquant
												j2.list_ter.remove(t2); // suppression du territoire au joueur defenseur
												t2.position(t2, j1.getCouleur()); // affichage territoire conquis
												t1.position(t1, j1.getCouleur()); // affichage territoire attaquant
											} else if (att[0] <= def[0]) {
												sup_armee(t1, 1);
												t1.position(t1, j1.getCouleur());
											}
										} else if ((att.length == 1 && def.length == 2)) {
											if (att[0] > def[0]) {
												sup_armee(t2, 1);
												t2.position(t2, j2.getCouleur());
											} else if (att[0] <= def[0]) {
												sup_armee(t1, 1);
												t1.position(t1, j1.getCouleur());
											}
										}
									} else {
										t1.position(t1, j1.getCouleur()); // renvoie la couleur couleur du joueur
																			// lorsqu'il se trompe
									}

									StdDraw.pause(500);
									break;
								}
							}
							StdDraw.pause(500);
							break;
						}
					}
				} else if (105 < x && x < 115 && 87 < y && y < 93) { // lorsqu'on clique sur "finir"
					StdDraw.pause(500);
					break; // arrêt de la phase attaque
				} else {
					StdDraw.pause(500);
				}

			} else {

			}
		}
	}

	public void deplacement(int d, Joueur j) throws InterruptedException {
		while (d != 0) {
			if (StdDraw.mousePressed()) { // clique sur un des boutons à droite
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				if (105 < x && x < 115 && 67 < y && y < 73) { // lorsqu'on clique sur "mouvement"
					System.out.println("choisir un pays");
					StdDraw.pause(500);
					while (d != 0) {
						if (StdDraw.mousePressed()) { // clique sur un territoire
							territoire t1 = choix_pays(1, j); // selection armée à déplacer
							t1.position(t1, StdDraw.YELLOW); // affichage du pays qui attaque
							System.out.println("choisir le territoire");
							StdDraw.pause(500);
							while (d != 0) {
								if (StdDraw.mousePressed()) {// clique sur le territoire de destination
									territoire t2 = choix_pays(1, j); // selection du territoire de destination

									if (verif(t1, t2) == true) {
										int c = t1.getA() - 1; // unité max que le joueur peut déplacer

										Sliders slide = new Sliders(1, c); // création de la fenêtre pop up
										slide.setVisible(true); // rend visible cette fenêtre
										TimeUnit.SECONDS.sleep(5); // laisse un temps de réponse au joueur
										int h = slide.getResultat(); // récupère le choix du joueur
										add_armee(t2, h); // ajout armee sur territoire de destination
										sup_armee(t1, h); // suppression armee sur territoire source
										t2.position(t2, j.getCouleur()); // affichage territoire destination
										t1.position(t1, j.getCouleur()); // affichage territoire source
										break;
									} else {
										t1.position(t1, j.getCouleur()); // renvoie la couleur couleur du joueur
																			// lorsqu'il se trompe
									}
									StdDraw.pause(500);
									break;
								}
							}
							StdDraw.pause(500);
							break;
						}
					}
				} else if (105 < x && x < 115 && 87 < y && y < 93) { // lorsqu'on clique sur "finir"
					StdDraw.pause(500);
					break; // arrêt de la phase déplacement
				} else {
					StdDraw.pause(500);
				}

			} else {

			}
		}
	}

	public boolean verif(territoire t1, territoire t2) {
		// Amérique du nord
		if (t1.getNumero() == 1) {
			if (t2.getNumero() == 2) {
				return true;
			} else if (t2.getNumero() == 6) {
				return true;
			} else if (t2.getNumero() == 36) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 2) {
			if (t2.getNumero() == 1) {
				return true;
			} else if (t2.getNumero() == 6) {
				return true;
			} else if (t2.getNumero() == 7) {
				return true;
			} else if (t2.getNumero() == 9) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 3) {
			if (t2.getNumero() == 4) {
				return true;
			} else if (t2.getNumero() == 9) {
				return true;
			} else if (t2.getNumero() == 13) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 4) {
			if (t2.getNumero() == 3) {
				return true;
			} else if (t2.getNumero() == 7) {
				return true;
			} else if (t2.getNumero() == 8) {
				return true;
			} else if (t2.getNumero() == 9) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 5) {
			if (t2.getNumero() == 6) {
				return true;
			} else if (t2.getNumero() == 7) {
				return true;
			} else if (t2.getNumero() == 8) {
				return true;
			} else if (t2.getNumero() == 21) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 6) {
			if (t2.getNumero() == 1) {
				return true;
			} else if (t2.getNumero() == 2) {
				return true;
			} else if (t2.getNumero() == 5) {
				return true;
			} else if (t2.getNumero() == 7) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 7) {
			if (t2.getNumero() == 2) {
				return true;
			} else if (t2.getNumero() == 4) {
				return true;
			} else if (t2.getNumero() == 5) {
				return true;
			} else if (t2.getNumero() == 6) {
				return true;
			} else if (t2.getNumero() == 8) {
				return true;
			} else if (t2.getNumero() == 9) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 8) {
			if (t2.getNumero() == 4) {
				return true;
			} else if (t2.getNumero() == 5) {
				return true;
			} else if (t2.getNumero() == 7) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 9) {
			if (t2.getNumero() == 2) {
				return true;
			} else if (t2.getNumero() == 3) {
				return true;
			} else if (t2.getNumero() == 4) {
				return true;
			} else if (t2.getNumero() == 7) {
				return true;
			} else {
				return false;
			}
		}
		// Amerique du Sud
		if (t1.getNumero() == 10) {
			if (t2.getNumero() == 11) {
				return true;
			} else if (t2.getNumero() == 12) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 11) {
			if (t2.getNumero() == 10) {
				return true;
			} else if (t2.getNumero() == 12) {
				return true;
			} else if (t2.getNumero() == 13) {
				return true;
			} else if (t2.getNumero() == 18) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 12) {
			if (t2.getNumero() == 10) {
				return true;
			} else if (t2.getNumero() == 11) {
				return true;
			} else if (t2.getNumero() == 13) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 13) {
			if (t2.getNumero() == 11) {
				return true;
			} else if (t2.getNumero() == 12) {
				return true;
			} else if (t2.getNumero() == 3) {
				return true;
			} else {
				return false;
			}
		}
		// Afrique
		if (t1.getNumero() == 14) {
			if (t2.getNumero() == 15) {
				return true;
			} else if (t2.getNumero() == 18) {
				return true;
			} else if (t2.getNumero() == 19) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 15) {
			if (t2.getNumero() == 14) {
				return true;
			} else if (t2.getNumero() == 16) {
				return true;
			} else if (t2.getNumero() == 17) {
				return true;
			} else if (t2.getNumero() == 18) {
				return true;
			} else if (t2.getNumero() == 19) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 16) {
			if (t2.getNumero() == 15) {
				return true;
			} else if (t2.getNumero() == 18) {
				return true;
			} else if (t2.getNumero() == 24) {
				return true;
			} else if (t2.getNumero() == 37) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 17) {
			if (t2.getNumero() == 15) {
				return true;
			} else if (t2.getNumero() == 19) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 18) {
			if (t2.getNumero() == 16) {
				return true;
			} else if (t2.getNumero() == 15) {
				return true;
			} else if (t2.getNumero() == 14) {
				return true;
			} else if (t2.getNumero() == 11) {
				return true;
			} else if (t2.getNumero() == 25) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 19) {
			if (t2.getNumero() == 14) {
				return true;
			} else if (t2.getNumero() == 15) {
				return true;
			} else if (t2.getNumero() == 17) {
				return true;
			} else {
				return false;
			}
		}
		// Europe
		if (t1.getNumero() == 20) {
			if (t2.getNumero() == 21) {
				return true;
			} else if (t2.getNumero() == 22) {
				return true;
			} else if (t2.getNumero() == 23) {
				return true;
			} else if (t2.getNumero() == 26) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 21) {
			if (t2.getNumero() == 5) {
				return true;
			} else if (t2.getNumero() == 23) {
				return true;
			} else if (t2.getNumero() == 20) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 22) {
			if (t2.getNumero() == 23) {
				return true;
			} else if (t2.getNumero() == 20) {
				return true;
			} else if (t2.getNumero() == 26) {
				return true;
			} else if (t2.getNumero() == 24) {
				return true;
			} else if (t2.getNumero() == 25) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 23) {
			if (t2.getNumero() == 21) {
				return true;
			} else if (t2.getNumero() == 20) {
				return true;
			} else if (t2.getNumero() == 22) {
				return true;
			} else if (t2.getNumero() == 25) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 24) {
			if (t2.getNumero() == 22) {
				return true;
			} else if (t2.getNumero() == 26) {
				return true;
			} else if (t2.getNumero() == 25) {
				return true;
			} else if (t2.getNumero() == 16) {
				return true;
			} else if (t2.getNumero() == 37) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 25) {
			if (t2.getNumero() == 23) {
				return true;
			} else if (t2.getNumero() == 22) {
				return true;
			} else if (t2.getNumero() == 24) {
				return true;
			} else if (t2.getNumero() == 37) {
				return true;
			} else if (t2.getNumero() == 31) {
				return true;
			} else if (t2.getNumero() == 41) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 26) {
			if (t2.getNumero() == 20) {
				return true;
			} else if (t2.getNumero() == 22) {
				return true;
			} else if (t2.getNumero() == 24) {
				return true;
			} else if (t2.getNumero() == 18) {
				return true;
			} else {
				return false;
			}
		}
		// Océanie
		if (t1.getNumero() == 27) {
			if (t2.getNumero() == 29) {
				return true;
			} else if (t2.getNumero() == 30) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 28) {
			if (t2.getNumero() == 39) {
				return true;
			} else if (t2.getNumero() == 29) {
				return true;
			} else if (t2.getNumero() == 30) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 29) {
			if (t2.getNumero() == 27) {
				return true;
			} else if (t2.getNumero() == 28) {
				return true;
			} else if (t2.getNumero() == 30) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 30) {
			if (t2.getNumero() == 27) {
				return true;
			} else if (t2.getNumero() == 28) {
				return true;
			} else if (t2.getNumero() == 29) {
				return true;
			} else {
				return false;
			}
		}
		// Asie
		if (t1.getNumero() == 31) {
			if (t2.getNumero() == 25) {
				return true;
			} else if (t2.getNumero() == 37) {
				return true;
			} else if (t2.getNumero() == 41) {
				return true;
			} else if (t2.getNumero() == 33) {
				return true;
			} else if (t2.getNumero() == 32) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 32) {
			if (t2.getNumero() == 39) {
				return true;
			} else if (t2.getNumero() == 33) {
				return true;
			} else if (t2.getNumero() == 31) {
				return true;
			} else if (t2.getNumero() == 41) {
				return true;
			} else if (t2.getNumero() == 40) {
				return true;
			} else if (t2.getNumero() == 38) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 33) {
			if (t2.getNumero() == 39) {
				return true;
			} else if (t2.getNumero() == 32) {
				return true;
			} else if (t2.getNumero() == 31) {
				return true;
			} else if (t2.getNumero() == 37) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 34) {
			if (t2.getNumero() == 38) {
				return true;
			} else if (t2.getNumero() == 36) {
				return true;
			} else if (t2.getNumero() == 42) {
				return true;
			} else if (t2.getNumero() == 40) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 35) {
			if (t2.getNumero() == 38) {
				return true;
			} else if (t2.getNumero() == 36) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 36) {
			if (t2.getNumero() == 1) {
				return true;
			} else if (t2.getNumero() == 35) {
				return true;
			} else if (t2.getNumero() == 38) {
				return true;
			} else if (t2.getNumero() == 34) {
				return true;
			} else if (t2.getNumero() == 42) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 37) {
			if (t2.getNumero() == 15) {
				return true;
			} else if (t2.getNumero() == 16) {
				return true;
			} else if (t2.getNumero() == 24) {
				return true;
			} else if (t2.getNumero() == 25) {
				return true;
			} else if (t2.getNumero() == 31) {
				return true;
			} else if (t2.getNumero() == 33) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 38) {
			if (t2.getNumero() == 32) {
				return true;
			} else if (t2.getNumero() == 34) {
				return true;
			} else if (t2.getNumero() == 35) {
				return true;
			} else if (t2.getNumero() == 36) {
				return true;
			} else if (t2.getNumero() == 40) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 39) {
			if (t2.getNumero() == 32) {
				return true;
			} else if (t2.getNumero() == 33) {
				return true;
			} else if (t2.getNumero() == 28) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 40) {
			if (t2.getNumero() == 32) {
				return true;
			} else if (t2.getNumero() == 38) {
				return true;
			} else if (t2.getNumero() == 34) {
				return true;
			} else if (t2.getNumero() == 42) {
				return true;
			} else if (t2.getNumero() == 41) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 41) {
			if (t2.getNumero() == 25) {
				return true;
			} else if (t2.getNumero() == 31) {
				return true;
			} else if (t2.getNumero() == 32) {
				return true;
			} else if (t2.getNumero() == 40) {
				return true;
			} else {
				return false;
			}
		}
		if (t1.getNumero() == 42) {
			if (t2.getNumero() == 36) {
				return true;
			} else if (t2.getNumero() == 34) {
				return true;
			} else if (t2.getNumero() == 40) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public int verif_region(Joueur j) {
		Region r1 = new Region(1);
		Region r2 = new Region(2);
		Region r3 = new Region(3);
		Region r4 = new Region(4);
		Region r5 = new Region(5);
		Region r6 = new Region(6);
		ArrayList<Integer> h1 = new ArrayList<Integer>();
		ArrayList<Integer> h2 = new ArrayList<Integer>();
		ArrayList<Integer> h3 = new ArrayList<Integer>();
		ArrayList<Integer> h4 = new ArrayList<Integer>();
		ArrayList<Integer> h5 = new ArrayList<Integer>();
		ArrayList<Integer> h6 = new ArrayList<Integer>();
		int bonus=0;
		int	a1=0;
		int a2=0;
		int a3=0;
		int a4=0;
		int a5=0;
		int a6=0;
		for (int i=1;i<=9;i++) {
			if(j.recherche_ter(i,j)==null) {
				h1.add(0);
			}
			else {
				h1.add(j.recherche_ter(i,j).getNumero());  
				a1=a1+1;
			}
		}
		if(a1==9) {
			bonus=bonus+5;
		}
		for (int i=10;i<=13;i++) {
			if(j.recherche_ter(i,j)==null) {
				h2.add(0);
			}
			else {
				h2.add(j.recherche_ter(i,j).getNumero()); 
				a2=a2+1;
			} 
		}
		if(a2==4) {
			bonus=bonus+2;
		}
		for (int i=14;i<=19;i++) {
			if(j.recherche_ter(i,j)==null) {
				h3.add(0);
			}
			else {
				h3.add(j.recherche_ter(i,j).getNumero()); 
				a3=a3+1;
			} 
		}
		if(a3==6) {
			bonus=bonus+3;
		}
		for (int i=20;i<=26;i++) {
			if(j.recherche_ter(i,j)==null) {
				h4.add(0);
			}
			else {
				h4.add(j.recherche_ter(i,j).getNumero()); 
				a4=a4+1;
			} 
		}
		if(a4==7) {
			bonus=bonus+5;
		}
		for (int i=27;i<=30;i++) {
			if(j.recherche_ter(i,j)==null) {
				h5.add(0);
			}
			else {
				h5.add(j.recherche_ter(i,j).getNumero()); 
				a5=a5+1;
			} 
		}
		if(a5==4) {
			bonus=bonus+2;
		}
		for (int i=31;i<=42;i++) {
			if(j.recherche_ter(i,j)==null) {
				h6.add(0);
			}
			else {
				h6.add(j.recherche_ter(i,j).getNumero()); 
				a6=a6+1;
			} 
		}
		if(a6==12) {
			bonus=bonus+7;
		}
		return bonus;
	}
}
