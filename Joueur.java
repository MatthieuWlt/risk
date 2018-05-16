import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Joueur {
	public int numero;
	Color couleur;
	String nomcoul;
	public ArrayList<territoire> list_ter;

	public Joueur(int numero, Color couleur, String nomcoul) {
		this.numero = numero;
		this.couleur = couleur;
		this.nomcoul = nomcoul;
		this.list_ter = new ArrayList<territoire>();
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

	public void attribution_mission(int numero_mission, int choix, Joueur j) {
		switch (numero_mission) {
		case 1:
			Random rand = new Random();
			System.out.println("La mission du joueur" + j.getNumero() + " est de détruire le joueur"
					+ rand.nextInt(choix - 1) + 1);
			break;
		case 2:
			System.out.println("La mission du joueur" + j.getNumero() + " est de conquérir tous les territoires");
			break;
		case 3:
			System.out.println(
					"La mission du joueur" + j.getNumero() + " est de contrôler 3 régions et au moins 18 territoires");
			break;
		case 4:
			System.out.println(
					"La mission du joueur" + j.getNumero() + " est de contrôler 18 territoires avec au moins 2 armées");
			break;
		case 5:
			System.out.println("La mission du joueur" + j.getNumero() + " est de contrôler 30 territoires");
			break;
		case 6:
			System.out.println("La mission du joueur" + j.getNumero() + " est de contrôler 24 territoires");
			break;
		case 7:
			System.out.println("La mission du joueur" + j.getNumero() + " est de contrôler 21 territoires");
			break;
		case 8:
			System.out.println("La mission du joueur" + j.getNumero()
					+ " est de contrôler la plus grosse région et une autre région()");
			break;
		}
	}

	public territoire recherche_ter(int num) {
		for (int i = 0; i < list_ter.size(); i++) {
			territoire h = list_ter.get(i);
			int j = h.getNumero();
			if (j == num) {
				return h;
			}
		}
		return null;
	}

	public void choix_pays(int choix4) {
		// ArrayList<territoire> list_ter=j.list_ter;
		while (choix4 != 0) {
			if (StdDraw.mousePressed()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				// Amérique
				if (86.7 < y && y < 90.7 && 5.2 < x && x < 9.2) {
					territoire t = recherche_ter(1);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (78 < y && y < 82 && 10.1 < x && x < 14.1) {
					territoire t = recherche_ter(2);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (56.9 < y && y < 60.9 && 9.8 < x && x < 13.8) {
					territoire t = recherche_ter(3);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (15.9 < x && x < 19.9 && 67.6 < y && y < 71.6) {
					territoire t = recherche_ter(4);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (33.8 < x && x < 37.8 && 91 < y && y < 95) {
					territoire t = recherche_ter(5);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (13.3 < x && x < 17.3 && 86.3 < y && y < 90.3) {
					territoire t = recherche_ter(6);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (17.3 < x && x < 21.3 && 78.9 < y && y < 82.9) {
					territoire t = recherche_ter(7);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (24.1 < x && x < 28.1 && 77.9 < y && y < 81.9) {
					territoire t = recherche_ter(8);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (9.4 < x && x < 13.4 && 70 < y && y < 74) {
					territoire t = recherche_ter(9);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				}
				// Amérique du sud
				else if (22.3 < x && x < 26.3 && 17.7 < y && y < 21.7) {
					territoire t = recherche_ter(10);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (25.9 < x && x < 29.9 && 32.5 < y && y < 36.5) {
					territoire t = recherche_ter(11);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (21.2 < x && x < 25.2 && 28.9 < y && y < 32.9) {
					territoire t = recherche_ter(12);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (20.5 < x && x < 24.5 && 45.2 < y && y < 49.2) {
					territoire t = recherche_ter(13);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				}
				// Afrique
				else if (50.1 < x && x < 54.1 && 40.2 < y && y < 44.2) {
					territoire t = recherche_ter(14);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (56.6 < x && x < 60.6 && 46.6 < y && y < 50.6) {
					territoire t = recherche_ter(15);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (50.5 < x && x < 54.5 && 60.7 < y && y < 64.7) {
					territoire t = recherche_ter(16);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (58.7 < x && x < 62.7 && 26.2 < y && y < 30.2) {
					territoire t = recherche_ter(17);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (42.6 < x && x < 46.6 && 53.6 < y && y < 57.6) {
					territoire t = recherche_ter(18);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (50.5 < x && x < 54.5 && 26.2 < y && y < 30.2) {
					territoire t = recherche_ter(19);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				}
				// Europe
				else if (42.3 < x && x < 46.3 && 79 < y && y < 83) {
					territoire t = recherche_ter(20);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (38.7 < x && x < 42.7 && 84.6 < y && y < 88.6) {
					territoire t = recherche_ter(21);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (47.6 < x && x < 51.6 && 77.6 < y && y < 81.6) {
					territoire t = recherche_ter(22);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (47.6 < x && x < 51.6 && 84.6 < y && y < 88.6) {
					territoire t = recherche_ter(23);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (50.1 < x && x < 54.1 && 71.9 < y && y < 75.9) {
					territoire t = recherche_ter(24);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (53.7 < x && x < 57.7 && 79.7 < y && y < 83.7) {
					territoire t = recherche_ter(25);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (43.7 < x && x < 47.7 && 71.9 < y && y < 75.9) {
					territoire t = recherche_ter(26);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				}
				// Océanie
				else if (90.1 < x && x < 94.1 && 21.9 < y && y < 25.9) {
					territoire t = recherche_ter(27);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (81.9 < x && x < 85.9 && 41 < y && y < 45) {
					territoire t = recherche_ter(28);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (90.9 < x && x < 94.9 && 36.7 < y && y < 40.7) {
					territoire t = recherche_ter(29);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (83 < x && x < 87 && 21.2 < y && y < 25.2) {
					territoire t = recherche_ter(30);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				}
				// Asie
				else if (63 < x && x < 67 && 72.6 < y && y < 76.6) {
					territoire t = recherche_ter(31);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (75.1 < x && x < 79.1 && 64.2 < y && y < 68.2) {
					territoire t = recherche_ter(32);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (68.7 < x && x < 72.7 && 57.9 < y && y < 61.9) {
					territoire t = recherche_ter(33);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (75.5 < x && x < 79.5 && 79 < y && y < 83) {
					territoire t = recherche_ter(34);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (88.3 < x && x < 92.3 && 67 < y && y < 71) {
					territoire t = recherche_ter(35);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (85.1 < x && x < 89.1 && 86 < y && y < 90) {
					territoire t = recherche_ter(36);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (56.9 < x && x < 60.9 && 64.2 < y && y < 68.2) {
					territoire t = recherche_ter(37);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (76.6 < x && x < 80.6 && 72.6 < y && y < 76.6) {
					territoire t = recherche_ter(38);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (77.3 < x && x < 81.3 && 52.2 < y && y < 56.2) {
					territoire t = recherche_ter(39);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (68.4 < x && x < 72.4 && 86 < y && y < 90) {
					territoire t = recherche_ter(40);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (62.6 < x && x < 66.6 && 83.2 < y && y < 87.2) {
					territoire t = recherche_ter(41);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				} else if (76.2 < x && x < 80.2 && 86 < y && y < 90) {
					territoire t = recherche_ter(42);
					add_armee(t, 1);
					t.position(t, couleur);
					StdDraw.pause(500);
					break;
				}
				break;
			} else {
			}
		}

	}

}
